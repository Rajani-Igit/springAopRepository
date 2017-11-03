package com.declarative.before.util;

public class AuthenticationManager {
	public UserInfo userInfo;
	private ThreadLocal< UserInfo> threadLocal;
    private static AuthenticationManager instance;
    private AuthenticationManager() {
    	threadLocal = new ThreadLocal<>();
    }
    
    
    public synchronized static AuthenticationManager getInstance() {
	   if(instance == null) {
		   instance = new AuthenticationManager();
	   }
	   return instance;
    }

    public void login(String userName , String password) {
    	userInfo = new UserInfo(userName, password);
    	threadLocal.set(userInfo);
    }
    public void logout() {
    	threadLocal.set(null);
    }
    public boolean authenticate() {
    	
    	return threadLocal.get().getUserName()!="" ? ((UserInfo)threadLocal.get()).getUserName().equals("sairam") && ((UserInfo)threadLocal.get()).getPassword().equals("welcome1"):false;
    	/*if(((UserInfo)threadLocal.get()).getUserName().equals("sairam") && ((UserInfo)threadLocal.get()).getPassword().equals("welcome1")) {
    		return true;
    	}*/
    	
    }
}
