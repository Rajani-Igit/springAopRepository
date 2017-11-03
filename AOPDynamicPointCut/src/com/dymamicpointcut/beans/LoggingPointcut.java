package com.dymamicpointcut.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class LoggingPointcut extends DynamicMethodMatcherPointcut {
     public LoggingPointcut() {
    	 System.out.println("LoggingPointCut Constructor will be called");
	}
	@Override
	public boolean matches(Method method, Class<?> classType, Object[] args) {
		System.out.println("inside the matches method from dynamic pointcut method matcher class");
		if(classType.isAssignableFrom(Calculator.class) && method.getName().equals("add") && (Integer)args[0]>100 && (Integer)args[1]>200) {
			System.out.println("inside the if condition if matches method from DynamicMethodMatcherSupport");
			return true;
		}
		return false;
	}

}
