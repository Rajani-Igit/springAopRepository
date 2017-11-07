package com.annotation.after.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KeyCheckAspect {
	
   /* For this we have to write returning value also.we have one attribute inside of this @AfterReturning Advice Annotation
    * so that it will place the return value inside ret attribute inside of the class
    *  */
   @AfterReturning(pointcut="target(com.annotation.after.beans.KeyGenrator)", returning="ret")
   public void check(JoinPoint joinPoint ,Object ret) {
	String methodName = null;
	Object[] args = null;
	methodName = joinPoint.getSignature().getName();
	args = joinPoint.getArgs();
	System.out.println("inside check method ");
	if((Integer)ret <= 0 ) {
		throw new IllegalArgumentException("Weak key is genrated");
	}
 }
}
