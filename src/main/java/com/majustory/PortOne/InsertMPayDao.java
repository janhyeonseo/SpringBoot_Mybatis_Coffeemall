package com.majustory.PortOne;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertMpayDao {
	int InsertMpayService(PortOneVO vo);
}
