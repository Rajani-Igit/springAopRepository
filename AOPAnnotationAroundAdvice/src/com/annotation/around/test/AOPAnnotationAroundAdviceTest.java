package com.annotation.around.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.annotation.around.beans.Calculator;

public class AOPAnnotationAroundAdviceTest {
   public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/annotation/around/common/application-context.xml");
	Calculator calculator = context.getBean("calculator", Calculator.class);
	int sum = calculator.add(10, 20);
	int multi = calculator.multiply(10, 20);	
	sum = calculator.add(10, 20); 
}
}

