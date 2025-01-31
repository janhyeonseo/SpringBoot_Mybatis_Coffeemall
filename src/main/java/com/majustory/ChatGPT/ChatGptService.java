package com.majustory.ChatGPT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class ChatGptService {

    @Value("${openai.api.key}")  // application.properties에서 API 키 불러오기
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://api.openai.com/v1/chat/completions";

    public String getResponse(String prompt) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey); // API 키 적용
            headers.set("Content-Type", "application/json");

            String keyvalue = "You are ChatGPT, a large language model trained by OpenAI";
            String body = String.format("{"
                    + "\"model\": \"gpt-3.5-turbo\","
                    + " \"messages\": "
                    + "[{\"role\": \"system\", \"content\": \"%s\"},"
                    + "{\"role\": \"user\", \"content\": \"%s\"}]}",
                    keyvalue, prompt);

            HttpEntity<String> entity = new HttpEntity<>(body, headers);
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

            return response.getBody();
        } catch (Exception e) {
            System.err.println("🚨 OpenAI API 호출 중 오류 발생: " + e.getMessage());
            return "{\"choices\": [{\"message\": {\"content\": \"오류가 발생했습니다. 다시 시도해 주세요.\"}}]}";
        }
    }
}
