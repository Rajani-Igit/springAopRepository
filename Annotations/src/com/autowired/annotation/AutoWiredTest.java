package com.autowired.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredTest {
  public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/autowired/annotation/application-context.xml");
	Robot robot = context.getBean("robot",Robot.class);
	System.out.println(robot);
}
}
