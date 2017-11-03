package com.throwsAdvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LoggingExceptionAdvice implements ThrowsAdvice {
      public void afterThrowing(Method method ,Object[] args , Object target,IllegalArgumentException iae ) {
       System.out.println("inside the afterThrowing class");	
       System.out.println("Exception is looged sucessfully "+iae.getStackTrace());
       }
	
	   /* public void afterThrowing(IllegalArgumentException iae) {
		System.out.println("inside the afterThrowing class");	
		System.out.println("Exception is looged sucessfully "+iae.getStackTrace());
		}*/
}
