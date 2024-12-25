package com.majustory.PortOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertMPayServiceImpl  implements InsertMPayService {

	@Autowired
	private InsertMPayDao  dao;
	
	@Override
	public int insertMPayService(PortOneVO vo) {
		
		return dao.insertMPayService(vo);	
		
	}
}
