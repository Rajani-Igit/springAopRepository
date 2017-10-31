package com.afteradvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class KeyAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object ret, Method method, Object[] args, Object target) throws Throwable {
		String methodName = null;
		methodName = method.getName();
		System.out.println("Entered into the afterReturning Advice method of KeyAdvice class");
		Integer integer = (Integer)ret;
		if(integer == 0) {
			throw new IllegalArgumentException("Weak Key is genrated");
		}
		
	}

}
