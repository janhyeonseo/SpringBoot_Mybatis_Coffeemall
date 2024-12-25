package com.majustory.ChatGPT;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/chat")
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("/ask")
    public String askChatGpt(String prompt, Model  model) throws Exception, DatabindException, IOException {
    	
	    System.out.println("prompt확인:" + prompt );
	        	
	    String  str  = chatGptService.getResponse(prompt);
	    	
	    System.out.println("prompt확인2:" + str );
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    
        JsonResponse jsonResponse = objectMapper.readValue(str, JsonResponse.class);
        String content = jsonResponse.getChoices()[0].getMessage().getContent();
        model.addAttribute("result", content);
          
        return  "ChatGPT/result.html";
    }
}