package com.majustory.product;

import java.util.List;

public interface ProductService {
   int pid();
   public  void  insert(ProductVO vo);
   public  List<ProductVO>  list(ProductVO vo);
   public  ProductVO  edit(ProductVO vo);
   public  void  cartInsert(ProductVO vo);
   
   public  List<ProductVO>  cartList(ProductVO vo);
   
   public  void cartDel (ProductVO vo);
   public  void cartDel2 (ProductVO vo);
   
   public int totalcount(ProductVO vo);
}
