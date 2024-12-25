package com.majustory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.majustory.login.LoginService;
import com.majustory.login.LoginVO;

@Service
public class SecurityUserDetailsService implements UserDetailsService  {
	
	SecurityUserDetailsService(){
		System.out.println("==>SecurityUserDetailsService");
	}
	
	@Autowired
	LoginService service;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginVO vo = new LoginVO();
		System.out.println("username확인:" + username);
		vo.setUsername(username);
		
		LoginVO user = service.getUser(vo);
		if (user == null) {
			throw  new UsernameNotFoundException(username + "사용자 없음");
		}else {
			return new SecurityUser(user);
		}
	}

}