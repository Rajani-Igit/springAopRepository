package com.declarative.before.util;

public class UserInfo {
private String userName;
private String password;
public String getUserName() {
	return userName;
}
public UserInfo(String userName, String password) {
	this.userName = userName;
	this.password = password;
}
public String getPassword() {
	return password;
}
}
