package com.majustory.ChatGPT;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class ChatGptService {
      
	private String apiKey =" 내 api";

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://api.openai.com/v1/chat/completions";

    public String getResponse(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        System.out.println("===> prompt(999) :" + prompt);
        
        // 2개의 매개변수를 받아서 결과를 리턴하고 있다. !!!
        String keyvalue = "You are ChatGPT, a large language model trained by OpenAI";
        
        String body = String.format("{"
                + "\"model\": \"gpt-3.5-turbo\","
                + " \"messages\": "
                + "[{\"role\": \"system\", \"content\": \"%s\"},"
                + "{\"role\": \"user\", \"content\": \"%s\"}]}",
                keyvalue ,  prompt );
        
         HttpEntity<String> entity = new HttpEntity<>(body, headers);      
         ResponseEntity<String> response 
                            = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);
       return response.getBody();
           
    }
}
