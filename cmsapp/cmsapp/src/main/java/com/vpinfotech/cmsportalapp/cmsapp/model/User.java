package com.vpinfotech.cmsportalapp.cmsapp.model;

public class User {
	
	private String role;
	private String userName;
	private Integer mobileNumber;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public String toString() {
		return "User [role=" + role + ", userName=" + userName + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
