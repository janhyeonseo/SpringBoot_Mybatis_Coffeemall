package com.majustory.PortOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/PortOneT")
@Controller
public class PortOneController {
	PortOneController(){
		System.out.println("==> PortOneController");
	}
	
	@Autowired
	InsertMpayService service;
	
	@ResponseBody
	@PostMapping("/insertMPay")
	String insertMPay(@RequestBody PortOneVO vo, Model  model){
		   System.out.println("==> insertMPay : "+vo.getMpaynum()+ ":" + vo.getMpayprice());
		   String OK = "";
		   int k =  service.InsertMpayService(vo);
		   if(k == 1) {
			   OK = "/PortOneT/result";
		   }else {
			   OK = "/PortOneT/fail";
		   }
		  
		return OK;
	}
	
	@GetMapping("/result")
	String result(Model  model){
		   System.out.println("==> result ");
		   model.addAttribute("result","hello");
		return "/product/result";	
	}
	
	@GetMapping("/fail")
	String fail(Model  model){
		   System.out.println("==> result ");
		   model.addAttribute("result","fail");
		return "/product/fail";	
	}
}


