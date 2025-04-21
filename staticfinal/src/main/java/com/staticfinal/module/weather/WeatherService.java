package com.staticfinal.module.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {
	private final String API_KEY = "694520423fed6c55fe03e3bfc03f182a";

    public Map<String, Object> getWeather(double lat, double lon) throws IOException {
        String urlStr = String.format(
            "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=metric&lang=kr&appid=%s",
            lat, lon, API_KEY);

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // JSON 파싱
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());

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

        double temp = root.get("main").get("temp").asDouble();
        double tempMin = root.get("main").get("temp_min").asDouble();
        double tempMax = root.get("main").get("temp_max").asDouble();
        Map<String, Object> result = new HashMap<>();
        result.put("city", city);
        result.put("description", description);
        result.put("temp", temp);
        result.put("tempMin", tempMin);
        result.put("tempMax", tempMax);
        result.put("icon", icon);

        return result;
    }
}
