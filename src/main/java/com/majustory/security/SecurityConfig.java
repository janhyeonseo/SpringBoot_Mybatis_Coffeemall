package com.majustory.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	SecurityConfig(){
		System.out.println("==>SecurityConfig");
	}
	
	@Autowired
	SecurityUserDetailsService	securityUserDetail;
	
	@Bean
	SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		// hasRole : 하나의 역할을 지정할때.
		// hasAnyRole : hasAnyRole("MANAGER", "ADMIN") - 여러 역할을 지정할때.
		// 1. "/chatGPT/**" 와 "/product/productForm" 는 관리자만 접근
		// 2. "/product/cartList" 는 ADMIN 와 MEMBER만 접근
		// 3. "/product/**" 는 인증받은 모든 사람이 접근  

		http.authorizeHttpRequests(authorize -> authorize	              
	              .requestMatchers("/chatGPT/**","/product/productForm").hasRole("ADMIN")
	              .requestMatchers("/product/cartList").hasAnyRole("ADMIN", "MEMBER")	 
	              .requestMatchers("/product/**").authenticated()
	              .requestMatchers("/login/loginform","/login/userform").permitAll() // 회원가입 페이지는 인증 없이 접근 가능
	              .anyRequest().permitAll())
				
		.csrf(csrf -> csrf.disable())
	    
		// 로그인 설정
        .formLogin(login -> login
            .loginPage("/login/loginForm")
            .defaultSuccessUrl("/login/loginSuccess", false)) // 이전 요청 URL로 리다이렉트
        // 예외 처리
        .exceptionHandling(handling -> handling
            .accessDeniedPage("/login/accessDenied"))
        // 로그아웃 설정
        .logout(logout -> logout
            .invalidateHttpSession(true)
            .logoutSuccessUrl("/"))
        // 사용자 정보 서비스
        .userDetailsService(securityUserDetail);
		return http.build(); 
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();		
	}
}