package com.required.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class RequiredTest {
  /**
 * If you go for Annotations BeanFactory Does not support Annotations so we have to use 
 * ApplicationContext
 */
public static void main(String[] args) {
	  
	//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/required/annotation/application-context.xml"));
	ApplicationContext context = new ClassPathXmlApplicationContext("com/required/annotation/application-context.xml");
	Robot robot = context.getBean("robot",Robot.class);
	System.out.println(robot);
}
}
