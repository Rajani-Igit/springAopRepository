package com.throwsAdvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.throwsAdvice.beans.LoggingExceptionAdvice;
import com.throwsAdvice.beans.Thrower;

public class ThrowsAdviceTest {
  public static void main(String[] args) {
	ProxyFactory pf = new ProxyFactory();
	pf.setTarget(new Thrower());
	pf.addAdvice(new LoggingExceptionAdvice());
	Thrower thrower = (Thrower)pf.getProxy();
	thrower.exceptionThrowing();
}
}
