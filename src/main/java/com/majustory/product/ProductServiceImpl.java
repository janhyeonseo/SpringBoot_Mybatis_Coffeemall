package com.majustory.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao  dao;
	
	ProductServiceImpl(){
		System.out.println("==> ProductServiceImpl");
	}
	
	@Override
	public int pid() {
		return dao.pid();
	}

	@Override
	public void insert(ProductVO vo) {
		dao.insert(vo);		
	}

	@Override
	public List<ProductVO> list(ProductVO vo) {
		return dao.list(vo);
	}


	@Override
	public void cartInsert(ProductVO vo) {
		dao.cartInsert(vo);
		
	}

	@Override
	public ProductVO edit(ProductVO vo) {
		return dao.edit(vo);
	}

	@Override
	public List<ProductVO> cartList(ProductVO vo) {
		return dao.cartList(vo);
	}

	@Override
	public void cartDel(ProductVO vo) {
		dao.cartDel(vo);		
	}

	@Override
	public int totalcount(ProductVO vo) {
		// TODO Auto-generated method stub
		return dao.totalcount(vo);
	}

}
