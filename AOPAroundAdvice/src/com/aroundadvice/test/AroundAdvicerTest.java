package com.aroundadvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aroundadvice.beans.CacheAdvicer;
import com.aroundadvice.beans.Calculator;
import com.aroundadvice.beans.LoggingAdvicer;

public class AroundAdvicerTest {
   public static void main(String[] args) {
	ProxyFactory proxyFactory = new ProxyFactory();
	proxyFactory.setTarget(new Calculator());
	proxyFactory.addAdvice(new CacheAdvicer());
	proxyFactory.addAdvice(new LoggingAdvicer());
    Calculator calculator = (Calculator)proxyFactory.getProxy();
    
    calculator.add(10, 30);
    calculator.add(10, 30);
    calculator.add(10, 30);
	System.out.println("end of the main method");
}
}
