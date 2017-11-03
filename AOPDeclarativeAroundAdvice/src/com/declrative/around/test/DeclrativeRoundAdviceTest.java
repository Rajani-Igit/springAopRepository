package com.declrative.around.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.declrative.around.beans.Calculator;

public class DeclrativeRoundAdviceTest {
    public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/declrative/around/common/application-context.xml");
		Calculator calculator = context.getBean("calculator",Calculator.class);
		System.out.println("it is creating "+calculator.getClass().getName()+" Not the Calculator class object ");
		int sum = calculator.add(10, 20);
		System.out.println("-----------------------------");
		 sum = calculator.add(10, 20);
		//System.out.println("End of the main method return value is "+sum);
	}
}
