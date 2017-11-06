package com.declarative.afteradvice.aspect;

import org.aspectj.lang.JoinPoint;

public class KeyCheckAspect {
	
 public void check(JoinPoint joinPoint ,Object ret) {
	String methodName = null;
	Object[] args = null;
	methodName = joinPoint.getSignature().getName();
	args = joinPoint.getArgs();
	System.out.println("inside check method ");
	if((Integer)ret <= 0 ) {
		throw new IllegalArgumentException("Weak key is genrated");
	}
 }
}
