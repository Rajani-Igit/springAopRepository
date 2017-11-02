package com.beforeadvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("entered into the before method from Secrity Advice class");
		 AuthenticationManager authenticationManager = null;
		 authenticationManager = AuthenticationManager.getInstance();
		 boolean authenticate = authenticationManager.authenticate();
		 if(authenticate == false) {
			 System.out.println("invalid userName or Password ");
			 throw new IllegalAccessException("Invalid UserName and Password");
		 }
	}

}
