package com.staticfinal.module.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {
	@RequestMapping(value = "/publicCorona1JsonNodeList")
	public String publicCorona1JsonNodeList(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=dNLcjyriV9IBD5djvIMsq16GYwW%2F8N%2FCtnCNvRj66yaLV9jXKhipDNCJFDcDzorgqnVsJsz5gmYoibNbAG0sdw%3D%3D&numOfRows=3&pageNo=1&type=json";
		String apiUrls = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq?serviceKey=%2BhIw20qpsqDVzHcDEoqxLM5wsDMSBrbMv4kVTpOA3Pr0fCalVlbDd89Z99bYyEKtZa9YsonwPMLEWq035GqvKw%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		URL urls = new URL(apiUrls);
		HttpURLConnection httpURLConnections = (HttpURLConnection) urls.openConnection();
		httpURLConnections.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		BufferedReader bufferedReaders;
		if (httpURLConnections.getResponseCode() >= 200 && httpURLConnections.getResponseCode() <= 300) {
			bufferedReaders = new BufferedReader(new InputStreamReader(httpURLConnections.getInputStream()));
		} else {
			bufferedReaders = new BufferedReader(new InputStreamReader(httpURLConnections.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();
		
		StringBuilder stringBuilders = new StringBuilder();
		String lines;
		while ((lines = bufferedReaders.readLine()) != null) {
			System.out.println("lines: " + lines);
			stringBuilders.append(lines);
		}
		
		bufferedReaders.close();
		httpURLConnections.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		JsonNode nodes = objectMapper.readTree(stringBuilder.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("nodes.get(\"header\").get(\"resultCode\").asText(): " + nodes.get("header").get("resultCode").asText());
		System.out.println("nodes.get(\"body\").get(\"totalCount\").asText(): " + nodes.get("body").get("totalCount").asText());
		System.out.println("nodes.get(\"header\").get(\"resultMsg\").asText(): " + nodes.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		model.addAttribute("node", node);
		model.addAttribute("nodes",nodes);
//		model.addAttribute(node);
		
		return "xdm/test/publicCorona1JsonNodeList";
	}
}
