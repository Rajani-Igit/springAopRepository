package com.declarative.thro.aspect;

import org.aspectj.lang.JoinPoint;

public class GlobalLoggingExceptionAspect {
	
   public void exceptionLog(JoinPoint jp ,IllegalArgumentException iae) {
	   String methodName = null;
	   Object[] args = null;
	   methodName = jp.getSignature().getName();
	   args = jp.getArgs();
	   System.out.println("performing logging from the ExceptionLog class");
	   System.out.println("Exception is raised in "+methodName+"("+args[0]+")");
   }
}
