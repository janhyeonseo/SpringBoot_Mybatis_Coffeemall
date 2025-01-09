package com.majustory.PortOne;

import lombok.Data;

@Data
public class PortOneVO {
  private  String gname;
  private  String gymnum;
  private  String mmail;
  private  String mname;  
  private  String mphone;
  private  String membernum;    
  
  private  String dataName;
  private  int dataPrice;
  private  String dataGoodsnum;
  
  private  String Mpaynum;
  private  int Mpayprice;
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public String getGymnum() {
	return gymnum;
}
public void setGymnum(String gymnum) {
	this.gymnum = gymnum;
}
public String getMmail() {
	return mmail;
}
public void setMmail(String mmail) {
	this.mmail = mmail;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getMphone() {
	return mphone;
}
public void setMphone(String mphone) {
	this.mphone = mphone;
}
public String getMembernum() {
	return membernum;
}
public void setMembernum(String membernum) {
	this.membernum = membernum;
}
public String getDataName() {
	return dataName;
}
public void setDataName(String dataName) {
	this.dataName = dataName;
}
public int getDataPrice() {
	return dataPrice;
}
public void setDataPrice(int dataPrice) {
	this.dataPrice = dataPrice;
}
public String getDataGoodsnum() {
	return dataGoodsnum;
}
public void setDataGoodsnum(String dataGoodsnum) {
	this.dataGoodsnum = dataGoodsnum;
}
public String getMpaynum() {
	return Mpaynum;
}
public void setMpaynum(String mpaynum) {
	Mpaynum = mpaynum;
}
public int getMpayprice() {
	return Mpayprice;
}
public void setMpayprice(int mpayprice) {
	Mpayprice = mpayprice;
}
}