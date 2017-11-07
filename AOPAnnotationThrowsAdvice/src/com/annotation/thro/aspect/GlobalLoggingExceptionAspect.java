package com.annotation.thro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
  /* This annotation is helpful in handling the throws Advice bcz we have class that log the all the exceptions occured throughout the
   * Application we can log by using throws advice the controller will come to here just before going to caller
   * so that we can advice and that throes exception also we have to provide as part of attribute inside the AfterThrowing Annotation
   * */
@Component
@Aspect
public class GlobalLoggingExceptionAspect {
	
   @AfterThrowing(pointcut="target(com.annotation.thro.aspect.GlobalLoggingExceptionAspect)",throwing="iae")
   public void exceptionLog(JoinPoint jp ,IllegalArgumentException iae) {
	   String methodName = null;
	   Object[] args = null;
	   methodName = jp.getSignature().getName();
	   args = jp.getArgs();
	   System.out.println("performing logging from the ExceptionLog class");
	   System.out.println("Exception is raised in "+methodName+"("+args[0]+")");
   }
}
