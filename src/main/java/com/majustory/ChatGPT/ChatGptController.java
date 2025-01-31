package com.majustory.ChatGPT;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/chat")
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("/ask")
    public String askChatGpt(@RequestParam("prompt") String prompt, Model model) {
        try {
            System.out.println("사용자 입력: " + prompt);
            String str = chatGptService.getResponse(prompt);
            System.out.println("AI 응답: " + str);

            // ObjectMapper 설정 변경
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 예상치 못한 필드 무시

            JsonResponse jsonResponse = objectMapper.readValue(str, JsonResponse.class);
            String content = jsonResponse.getChoices()[0].getMessage().getContent();
            model.addAttribute("result", content);

            return "ChatGPT/form.html";
        } catch (Exception e) {
            System.err.println("API 호출 중 오류 발생: " + e.getMessage());
            model.addAttribute("result", "오류가 발생했습니다. 다시 시도해주세요.");
            return "ChatGPT/form.html";
        }
    }

}
