package com.afteradvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SMSPlanProvider implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object ret, Method method, Object[] args, Object target) throws Throwable {
	   String mobileNo = null;
	   int amount = 0;
	   mobileNo =(String) args[0];
	   amount = (Integer) args[1];
	   System.out.println("You mobile number gets a special plan.if you recharge with "+amount+" Full talktime you will get");
	}

}
