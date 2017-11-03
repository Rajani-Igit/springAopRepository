package com.staticpointcut.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.staticpointcut.beans.Calculator;
import com.staticpointcut.beans.LoggingAdvice;
import com.staticpointcut.beans.LoggingStaticPointCut;

public class StaticPointCutTest {
   public static void main(String[] args) {
	ProxyFactory factory = new ProxyFactory();
	factory.setTarget(new Calculator());
	//factory.addAdvice(new LoggingAdvice());
	factory.addAdvisor(new DefaultPointcutAdvisor(new LoggingStaticPointCut(), new LoggingAdvice()));
	Calculator calculator = (Calculator)factory.getProxy();
	System.out.println(calculator.getClass());
	/*for(Method method : calculator.getClass().getDeclaredMethods()) {
		System.out.println("Method names are declared is  "+method.getName());
	}*/
	int ad = calculator.add(10, 20);
	int mul = calculator.multiply(10,20);
	System.out.println("End of the main");
}
   
}

