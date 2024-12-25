package com.majustory.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao  dao;
		
	@Override
	public LoginVO getUser(LoginVO vo) {
		return dao.getUser(vo);
	}
 
}
