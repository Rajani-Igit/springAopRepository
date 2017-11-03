package com.lookup.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookupTest {
   public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/lookup/annotation/application-context.xml");
	Container container = context.getBean("container",Container.class);
	container.service("Test Data 1  ");
	container.service("Test Data 2  ");
	container.service("Test Data 3  ");
	
	RequestHandler requestHandler1 = context.getBean("requestHandler", RequestHandler.class);
	RequestHandler requestHandler2 = context.getBean("requestHandler", RequestHandler.class);
	System.out.println("requestHandler1 == requestHandler2 ? "+ (requestHandler1 == requestHandler2 ?"true":"false"));
}
}
