package com.majustory.PortOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertMpayServiceImpl implements InsertMpayService{

	@Autowired
	private InsertMpayDao dao;
	
	@Override
	public int InsertMpayService(PortOneVO vo) {
		return dao.InsertMpayService(vo);
		
	}

}
