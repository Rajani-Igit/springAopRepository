package com.staticpointcut.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class LoggingStaticPointCut extends StaticMethodMatcherPointcut  {
     public LoggingStaticPointCut() {
    	 System.out.println("LoggingStaticPointCut Constructor called");
	}
	@Override
	public boolean matches(Method method, Class<?> arg) {
		System.out.println("inside matches method of LoggingStaticPointcut");
		//System.out.println("method name for this is calling "+method.getName());
		if(arg.isAssignableFrom(Calculator.class) && method.getName().equalsIgnoreCase("add")) {
			System.out.println("inside if condition");
			return true;
		}
		return false;
	}
	
}
