package com.staticfinal.module.weather;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	
	 @Autowired
	 WeatherService weatherService;

	    @PostMapping("/api/weather")
	    public Map<String, Object> getWeather(@RequestBody Map<String, Double> location) throws IOException {
	        double lat = location.get("lat");   // 받은 위도
	        double lon = location.get("lon");   // 받은 경도
	        return weatherService.getWeather(lat, lon); // 날씨 가져와서 응답
	    }
}
