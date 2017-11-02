package com.beforeadvice.beans;

public class UserInfo {
   private String userName;
   private String password;
public UserInfo(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}
public String getUserName() {
	System.out.println("");
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

   
}
