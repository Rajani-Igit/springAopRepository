package com.declarative.before.aspect;

import org.aspectj.lang.JoinPoint;

import com.declarative.before.util.AuthenticationManager;

public class AuditingAspect {
	private AuthenticationManager authenticationManager;
	
public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	this.authenticationManager = authenticationManager;
}

public void audit(JoinPoint joinPoint) {
	String methodName = null;
	Object[] args = null;
	methodName = joinPoint.getSignature().getName();
	args = joinPoint.getArgs();
	System.out.println("inside the AuditingAspect class from ");
	System.out.println(authenticationManager.userInfo.getUserName()+" is calling the "+methodName+"("+args[0]+")");
}
}
