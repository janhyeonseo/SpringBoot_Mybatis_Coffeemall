package com.maju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	
	StartController(){
		System.out.println("==> StartController 생성자");
	}
	
	@GetMapping("/index")
	void index(){}
}
