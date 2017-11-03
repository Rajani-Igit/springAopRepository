package com.dynamicpointcut.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.dymamicpointcut.beans.Calculator;
import com.dymamicpointcut.beans.LoggingAdvice;
import com.dymamicpointcut.beans.LoggingPointcut;

public class DynamicPointcutTest {
    public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new Calculator());
		pf.addAdvisor(new DefaultPointcutAdvisor(new LoggingPointcut()	, new LoggingAdvice()));
		Calculator calculator = (Calculator)pf.getProxy();
		System.out.println(calculator.getClass());
		/*for(Method method : calculator.getClass().getDeclaredMethods()) {
			System.out.println("Method names are declared is  "+method.getName());
		}*/
		
		int adding = calculator.add(10, 20);
		System.out.println("first time adding  "+adding);
		System.out.println("second tie adding  "+calculator.add(101, 202));
		System.out.println("multiplaying the values  "+calculator.multiply(10, 20));
	}
}
