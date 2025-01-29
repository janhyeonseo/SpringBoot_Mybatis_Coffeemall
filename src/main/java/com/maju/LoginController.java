package com.maju;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.majustory.login.LoginService;
import com.majustory.login.LoginVO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private  LoginService  service;
	
	public LoginController(){
		System.out.println("==> LoginController");
	}
	
	@GetMapping("/loginForm")
	void loginForm(Model  model){
		   System.out.println("==> loginForm ");	

	}
	
    // 시큐리티 적용시 사용되지 않음. 
	@PostMapping("/loginFormOK")
	String loginFormOK(Model  model , LoginVO vo ){
		   System.out.println("==> loginFormOK ");	
		   LoginVO m  =  service.getUser(vo);
		   if (m != null) {
			   if (m.getPassword().equals(vo.getPassword())) {
				   System.out.println("==> 로그인 성공!! ");
				   return  "redirect:/login/success";
			   }else {
				   System.out.println("==> 로그인 실패!! ");
				   return  "redirect:/login/failure";
			   }
		   }else {
			   return  "redirect:/login/failure";
		   }
	}
	 
	@GetMapping("/loginSuccess")
	String success(HttpSession  session ){
		   System.out.println("==> success ");
		   session.setAttribute("USERNAME", "USERNAME");
		return "/login/success.html";	

	}
	@GetMapping("/failure")
	String failure(Model  model){
		   System.out.println("==> failure ");
		return "/login/failure.html";	
	}
	
	@GetMapping("/accessDenied")
	String accessDenied(Model  model){
		   System.out.println("==> accessDenied ");
		return "/login/accessDenied.html";
	}
	

	@GetMapping("/logOut")
	String logOut(Model  model,  HttpSession  session){
		   System.out.println("==> logOut ");
		   session.invalidate() ;
		return "redirect:/login/loginForm";
	}
	
	@GetMapping("/userform")
    public String MemberForm() {
		System.out.println("==> userform ");
        return "login/userform"; 
    }
	
	@PostMapping("/userformOK")
    public String memberformOK(LoginVO vo) {
		System.out.println("==> userform ");
		service.userInsert(vo);
        return "/login/loginform"; 
    }
}