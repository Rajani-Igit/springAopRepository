package com.dependson.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependsOnTest {
   public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/dependson/annotation/application-context.xml");
	LoadPlaner loadPlanner = context.getBean("loadPlaner",LoadPlaner.class);
	loadPlanner.calculate(20,24,"Hyderabad");
}
}
