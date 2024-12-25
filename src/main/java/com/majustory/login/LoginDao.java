package com.majustory.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	LoginVO  getUser( LoginVO vo );
}
