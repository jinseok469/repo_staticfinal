package com.staticfinal.module.kakao;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoService {
	


	    private final WebClient webClient = WebClient.create();
	    private  ObjectMapper mapper = new ObjectMapper();

	    private final String clientId = "3b69eb94e9cbee8dd8cb445e30b29a23"; // 카카오 REST API 키
	    private final String redirectUri = "http://localhost:8080/kakaoUsrProc"; // 등록된 리디렉트 URI

	    public KakaoDto getUserInfo(String code) throws Exception {

	        // 1. Access Token 요청
	        String tokenResponse = webClient.post()
	            .uri("https://kauth.kakao.com/oauth/token")
	            .header("Content-Type", "application/x-www-form-urlencoded")
	            .bodyValue("grant_type=authorization_code"
	                    + "&client_id=" + clientId
	                    + "&redirect_uri=" + redirectUri
	                    + "&code=" + code)
	            .retrieve()
	            .bodyToMono(String.class)
	            .block();

	        JsonNode tokenJson = mapper.readTree(tokenResponse);
	        String accessToken = tokenJson.get("access_token").asText();

	        // 2. 사용자 정보 요청
	        try {
	            String userInfo = webClient.get()
	                .uri("https://kapi.kakao.com/v2/user/me")
	                .header("Authorization", "Bearer " + accessToken)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();

	            JsonNode userJson = mapper.readTree(userInfo);
	            // ...
	            KakaoDto dto = new KakaoDto();
		        dto.setKakaoId(userJson.get("id").asText());  // 카카오 고유 ID
		        dto.setProfile_nickname(
		            userJson.path("kakao_account")
		                    .path("profile")
		                    .path("nickname").asText()
		        );
		        return dto;
	        } catch (WebClientResponseException e) {
	            System.out.println("카카오 사용자 정보 요청 실패: " + e.getResponseBodyAsString());
	            throw e; // 에러 다시 던짐
	        }

	        // 3. 사용자 정보 매핑
	       

	      
	    }
	}



