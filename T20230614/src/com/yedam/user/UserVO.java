package com.yedam.user;



public class UserVO {
	private String userId;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userPhone;
	private String userAddr;
	
	
	public UserVO(){
		
	}
	
	public UserVO(String userId, String userPw, String userName, String userBirth, String userPhone, String userAddr) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	
	@Override
	public String toString() {
		return "gd";
	}
	
}
