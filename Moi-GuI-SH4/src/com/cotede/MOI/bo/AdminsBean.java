package com.cotede.MOI.bo;

public class AdminsBean {
	private String userName;
	private String password;
	
	public AdminsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminsBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passPort) {
		this.password = passPort;
	}	
	@Override
	public String toString() {
		return "AdminsBean [userName=" + userName + ", passPort=" + password + "]";
	}
	
	

}
