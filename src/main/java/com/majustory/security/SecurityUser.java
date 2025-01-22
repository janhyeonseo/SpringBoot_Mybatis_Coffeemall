package com.majustory.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.majustory.login.LoginVO;

public class SecurityUser extends User {

    private static final long serialVersionUID = 1L;

    private String id; // 추가 필드: 사용자 ID

    public SecurityUser(LoginVO vo) {
        super(vo.getUsername(),
              "{noop}" + vo.getPassword(), 
              AuthorityUtils.createAuthorityList(vo.getRole().toString()));
        this.id = vo.getid(); // LoginVO의 id를 SecurityUser에 저장
    }

    public String getId() {
        return id; // id 값을 반환
    }
}
