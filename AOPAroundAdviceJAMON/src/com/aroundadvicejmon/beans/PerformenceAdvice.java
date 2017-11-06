package com.aroundadvicejmon.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class PerformenceAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		for(int i=0;i<args.length;i++) {
			if(i == 0) { 
				methodName += "("+args[i];
			}
			methodName += ","+args[i];
		}
		methodName += ")";
		System.out.println("Entered into the performence Advice method  "+methodName);
		Monitor monitor = MonitorFactory.start(methodName);
		Object intrestRate = methodInvocation.proceed();
		System.out.println("retuen Value is "+intrestRate);
		monitor.stop();
		System.out.println("exiting from the Performence Advisor");
		System.out.println(MonitorFactory.getReport());
		return intrestRate;
	}

}
