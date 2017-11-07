package com.annotation.before.util;

import org.springframework.stereotype.Component;

@Component
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
    	//System.out.println("inside login method");
    	userInfo = new UserInfo(userName, password);
    	threadLocal.set(userInfo);
    }
    public void logout() {
    	threadLocal.set(null);
    }
    public boolean authenticate() {
    	System.out.println("inside authenticate");
    	System.out.println("returning the value is  "+ (threadLocal.get().getUserName() !="" ? ((UserInfo)threadLocal.get()).getUserName().equals("sairam") && ((UserInfo)threadLocal.get()).getPassword().equals("welcome"):true));
    	return threadLocal.get().getUserName()!="" ? ((UserInfo)threadLocal.get()).getUserName().equals("sairam") && ((UserInfo)threadLocal.get()).getPassword().equals("welcome1"):true;
    	/*if(((UserInfo)threadLocal.get()).getUserName().equals("sairam") && ((UserInfo)threadLocal.get()).getPassword().equals("welcome1")) {
    		return true;
    	}*/
    	
    }
}
