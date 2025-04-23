package com.staticfinal.module.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {
	
	@Value("${openweather_api_key}")
	private String API_KEY;

    public Map<String, Object> getWeather(double lat, double lon) throws IOException {
        String urlStr = String.format(
            "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=metric&lang=kr&appid=%s",
            lat, lon, API_KEY);
        String urlArr = String.format(
        	    "https://api.openweathermap.org/data/3.0/onecall?lat=%s&lon=%s&exclude=current,minutely,hourly,alerts&units=metric&appid=%s",
        	    lat, lon, API_KEY
        	);
        URL url = new URL(urlStr);
        URL urls = new URL(urlArr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        HttpURLConnection conns = (HttpURLConnection) urls.openConnection();
        conns.setRequestMethod("GET");
        
        InputStream input = conn.getInputStream(); // 응답 데이터를 바이트로 받음
        InputStreamReader isr = new InputStreamReader(input, "UTF-8"); // 문자로 바꿔줌
        BufferedReader reader = new BufferedReader(isr); // 한 줄씩 읽기 쉽게 만듦
        InputStream inputs = conns.getInputStream(); // 응답 데이터를 바이트로 받음
        InputStreamReader isrs = new InputStreamReader(inputs, "UTF-8"); // 문자로 바꿔줌
        BufferedReader readers = new BufferedReader(isrs); // 한 줄씩 읽기 쉽게 만듦

        String response = ""; // 결과를 담을 변수
        String responseDaily = "";
        
        String line = reader.readLine(); // 한 줄 읽기
        while (line != null) {
            response += line; // 줄을 이어 붙이기
            line = reader.readLine(); // 다음 줄 읽기
        }

        reader.close(); // 끝나면 닫아주기
        String lines = readers.readLine();
        while(lines != null) {
        	responseDaily += lines;
        	lines = readers.readLine();
        }
        readers.close();
        // JSON 파싱
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());
        JsonNode root8 = mapper.readTree(responseDaily);
        
        JsonNode dailyArr = root8.get("daily");
        //daily Array 로 꺼내기
        List<WeatherDto> dailys = new ArrayList<WeatherDto>();
        for(int i = 0 ; i < 8; i++) {
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
       
         
        // 순수 방식으로 꺼내기
        String city = root.get("name").asText();
        String icon = root.get("weather").get(0).get("icon").asText();
        String description = "";
        JsonNode weatherArr = root.get("weather");
        for (int i = 0; i < weatherArr.size(); i++) {
            JsonNode weatherObj = weatherArr.get(i);
            description = weatherObj.get("description").asText();
            break; // 보통 첫 번째만 쓰므로 break 추가
        }
        
        double tempMin = dailyArr.get(0).get("temp").get("min").asDouble();
        double tempMax = dailyArr.get(0).get("temp").get("max").asDouble();
        double temp = root.get("main").get("temp").asDouble();
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
