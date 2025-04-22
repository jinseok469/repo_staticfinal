package com.staticfinal.module.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

        InputStream input = conn.getInputStream(); // 응답 데이터를 바이트로 받음
        InputStreamReader isr = new InputStreamReader(input, "UTF-8"); // 문자로 바꿔줌
        BufferedReader reader = new BufferedReader(isr); // 한 줄씩 읽기 쉽게 만듦

        String response = ""; // 결과를 담을 변수

        String line = reader.readLine(); // 한 줄 읽기
        while (line != null) {
            response += line; // 줄을 이어 붙이기
            line = reader.readLine(); // 다음 줄 읽기
        }

        reader.close(); // 끝나면 닫아주기
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
