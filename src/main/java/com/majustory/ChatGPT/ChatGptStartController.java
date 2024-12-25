package com.majustory.ChatGPT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatGptStartController {
	ChatGptStartController(){
		System.out.println("===> ChatGptStartController ");
	}
	
	@GetMapping("/chatGPT/start")
	public String  start() {
		
		return "ChatGPT/form.html" ;		
	}
}