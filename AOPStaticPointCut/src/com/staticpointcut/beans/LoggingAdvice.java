package com.staticpointcut.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {
   public LoggingAdvice() {
	   System.out.println("LoggingAdvice called");
   }
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = methodInvocation.getMethod().getName();
		System.out.println(methodName+" method called from LoggingAdvice class");
		Object ret = methodInvocation.proceed();
		System.out.println("The return value for "+methodName+" is "+ret);
		return ret;
	}

}
