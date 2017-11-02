package com.beforeadvice.beans;

public class AuthenticationManager {
  public UserInfo userInfo ;
  private ThreadLocal<UserInfo> threadLocal;
  private static AuthenticationManager instance;
  private AuthenticationManager() {
	threadLocal = new ThreadLocal<UserInfo>();
  }
  
  public synchronized static AuthenticationManager getInstance() {
	  if(instance == null) {
		  instance = new AuthenticationManager();
	  }
	  return instance;
  }
  
  public void login(String userName, String password) {
	  userInfo = new UserInfo(userName, password);
	  threadLocal.set(userInfo);
  }
  
  public void logout() {
	  threadLocal.remove();
  }
  
  public boolean authenticate() {
	  System.out.println("Entered into the authenticate method from AuthenticationManager");
	  UserInfo userInfo = threadLocal.get();
	  if(userInfo.getUserName().equals("sairam") && userInfo.getPassword().equals("welcome1")) {
		  return true;
	  }
	  return false;
  }
}
