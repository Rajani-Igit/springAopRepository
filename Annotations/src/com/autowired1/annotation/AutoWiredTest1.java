package com.autowired1.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredTest1 {
  public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/autowired1/annotation/application-context.xml");
	Robot robot = context.getBean("robot",Robot.class);
	System.out.println(robot);
}
}
