package com.declarative.before.aspect;

import org.aspectj.lang.JoinPoint;

import com.declarative.before.util.AuthenticationManager;

public class AuthenticationAspect {
  private AuthenticationManager authenticationManager;
  public void security(JoinPoint joinPoint) {
	  String methodName = null;
	  Object[] args = null;
	  methodName = joinPoint.getSignature().getName();
	  args = joinPoint.getArgs();
	  System.out.println(authenticationManager.userInfo.getUserName()+" acessing the method "+methodName+"("+args[0]+")");
	  if(authenticationManager.userInfo.getUserName().equals("sairam") == false) {
		  throw new IllegalArgumentException("provide valid userid and password");
	  }
  }
public AuthenticationManager getAuthenticationManager() {
	return authenticationManager;
}
public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	this.authenticationManager = authenticationManager;
}
}
