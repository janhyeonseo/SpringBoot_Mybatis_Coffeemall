package com.majustory.product;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
  private  String  pid;
  private  String  pname;
  private  int  pprice ;
  private  String  pdesc   ;
  private  String  pimgStr;
  private  MultipartFile pimg;
  private  String  today;
  private  int  cnt;
  
  private  String  cid;
  private  int amount; 
   
}
