package com.maju;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.majustory.product.ProductService;


@Controller
public class StartController {
	
	@Autowired
	private ProductService service;
	
	StartController(){
		System.out.println("==> StartController 생성자");
	}
	
	@GetMapping("/index")
	void index(Model model){
		model.addAttribute("li", service.list_index(null));
	}
}
