package com.aroundadvice.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvicer implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName =null;
		Object[] args = null;
		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		Object currentObject = methodInvocation.getThis();
		int len = args.length;
		System.out.println("enterd into LoggingAdvicer invoke method");
		System.out.print("Entering into the method  "+methodName+"  And the Arguments are (");
		for(int i=0;i<len;i++) {
			if(i == 0) {
				System.out.print(args[i]);
				System.out.print(",");
				continue;
			}
			System.out.print(args[i]);
		}
		System.out.println(")");
		
		Object object = methodInvocation.proceed();
		
		System.out.println("exiting out from the invoke method and returning the value is "+object);
		object = (Integer)object +60;
		return object;
	}

}
