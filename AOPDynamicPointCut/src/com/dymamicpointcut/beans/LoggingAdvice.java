package com.dymamicpointcut.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {
    public LoggingAdvice() {
    	System.out.println("LoggingAdvice will be called");
    }
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		methodName = methodInvocation.getMethod().getName();
		Object[] args = null;
		args = methodInvocation.getArguments();
		System.out.println("inside the invoke method and methodName is  "+methodName+"("+args[0]+" ,"+args[1]+")");
		Object ret = methodInvocation.proceed();
		System.out.println("after returning from the target class method and returns the value is "+ret);
		return ret;
	}

}
