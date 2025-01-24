package com.majustory.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
	public  int  pid();
	public  void  insert(ProductVO vo);
	public  List<ProductVO>  list(ProductVO vo);
	public  List<ProductVO>  list_index(ProductVO vo);
	public  ProductVO  edit(ProductVO vo);
	
	public  void  cartInsert(ProductVO vo);
	
	public  void cartDel (ProductVO vo);
	public  void cartDel2 (ProductVO vo);
	
	public  List<ProductVO>  cartList(ProductVO vo);
	
	public int totalcount(ProductVO vo);
}
