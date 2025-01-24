package com.majustory.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	public LoginVO getUser(LoginVO vo);
	public void userInsert(LoginVO vo);
}
