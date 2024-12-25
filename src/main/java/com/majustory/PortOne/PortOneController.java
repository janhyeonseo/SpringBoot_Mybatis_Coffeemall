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
		  System.out.println("==> PortOneController 확인 ");	
	}
	
	@Autowired
	InsertMPayService  service;  
	
	@ResponseBody
	@PostMapping("/insertMPay")
	public  String  productForm(@RequestBody PortOneVO vo ,Model  model){
		   // mpaynum : 결제번호 , mpayprice : 결제가격
		   System.out.println("==> insertMPay : " + vo.getMpaynum() +":"+ vo.getMpayprice());	
		   
		   String OK ="";
		   int  k = service.insertMPayService(vo) ;
		   System.out.println("===>k 확인 :" + k );
		   
		   if ( k == 1 ) {
		    OK = "/PortOneT/result";
		   } else {
		    OK = "/PortOneT/fail";
		   }
		return OK ;	
	}
	
	@GetMapping("/result")
	public String result( Model model) {		
		System.out.println("===> result 확인");
		model.addAttribute("result", "감사합니다. 조금만 기다려주세요!!");
		return "product/result.html" ;		
	}
	
	@GetMapping("/fail")
	public String fail( Model model) {		
		System.out.println("===> fail 확인");
		model.addAttribute("result", "fail");
		return "product/result.html" ;		
	}
	
}
