package com.majustory.login;

public interface LoginService {
	LoginVO getUser(LoginVO vo);
	public void userInsert(LoginVO vo);
}
