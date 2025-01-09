package com.majustory.login;

import lombok.Data;

@Data
public class LoginVO {
	private String pid;
	private String username;
	private String password;
	private String role;
	private String name;
	private String pimg;
	private String today;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}	
}
