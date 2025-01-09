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
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPprice() {
	return pprice;
}
public void setPprice(int pprice) {
	this.pprice = pprice;
}
public String getPdesc() {
	return pdesc;
}
public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}
public String getPimgStr() {
	return pimgStr;
}
public void setPimgStr(String pimgStr) {
	this.pimgStr = pimgStr;
}
public MultipartFile getPimg() {
	return pimg;
}
public void setPimg(MultipartFile pimg) {
	this.pimg = pimg;
}
public String getToday() {
	return today;
}
public void setToday(String today) {
	this.today = today;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
} 
  
}
