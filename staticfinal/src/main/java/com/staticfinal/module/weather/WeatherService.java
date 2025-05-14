package com.staticfinal.module.weather;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {
	
	@Value("${openweather_api_key}")
	private String API_KEY;

    public Map<String, Object> getWeather(double lat, double lon) throws IOException {
    	 WebClient webClient = WebClient.create("https://api.openweathermap.org");
         ObjectMapper mapper = new ObjectMapper();

         // 현재 날씨
         String currentUrl = String.format(
                 "/data/2.5/weather?lat=%f&lon=%f&units=metric&lang=kr&appid=%s",
                 lat, lon, API_KEY);

         // 일별 예보
         String dailyUrl = String.format(
                 "/data/3.0/onecall?lat=%f&lon=%f&exclude=current,minutely,hourly,alerts&units=metric&appid=%s",
                 lat, lon, API_KEY);

         String currentJsonStr = webClient.get()
                 .uri(currentUrl)
                 .retrieve()
                 .bodyToMono(String.class)
                 .block();

         String dailyJsonStr = webClient.get()
                 .uri(dailyUrl)
                 .retrieve()
                 .bodyToMono(String.class)
                 .block();

         JsonNode currentJson = mapper.readTree(currentJsonStr);
         JsonNode dailyJson = mapper.readTree(dailyJsonStr);
         JsonNode dailyArr = dailyJson.get("daily");

         List<WeatherDto> dailys = new ArrayList<>();
         for (int i = 0; i < 8; i++) {
             JsonNode dailyNode = dailyArr.get(i);
             JsonNode tempNode = dailyNode.get("temp");
             JsonNode weatherNode = dailyNode.get("weather").get(0);
             long dt = dailyNode.get("dt").asLong();
             LocalDate date = Instant.ofEpochSecond(dt).atZone(ZoneId.of("Asia/Seoul")).toLocalDate();
             String formattedDate = date.format(DateTimeFormatter.ofPattern("M월 d일"));

             WeatherDto dto = new WeatherDto();
             dto.setIcon(weatherNode.get("icon").asText());
             dto.setMax(tempNode.get("max").asDouble());
             dto.setMin(tempNode.get("min").asDouble());
             dto.setDate(formattedDate);
             dailys.add(dto);
         }

         String city = currentJson.get("name").asText();
         String icon = currentJson.get("weather").get(0).get("icon").asText();
         String description = currentJson.get("weather").get(0).get("description").asText();
         double temp = currentJson.get("main").get("temp").asDouble();
         double tempMin = dailyArr.get(0).get("temp").get("min").asDouble();
         double tempMax = dailyArr.get(0).get("temp").get("max").asDouble();

         Map<String, Object> result = new HashMap<>();
         result.put("city", city);
         result.put("description", description);
         result.put("temp", temp);
         result.put("tempMin", tempMin);
         result.put("tempMax", tempMax);
         result.put("icon", icon);
         result.put("daily", dailys);

         return result;
    }
}
