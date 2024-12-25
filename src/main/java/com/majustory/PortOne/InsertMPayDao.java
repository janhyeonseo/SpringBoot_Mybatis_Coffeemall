package com.majustory.PortOne;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertMPayDao {
	
	int	insertMPayService(PortOneVO vo);
      
}
