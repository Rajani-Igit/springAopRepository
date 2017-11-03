package com.javaconfigJ2EE.annotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {
   public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext("com.javaconfigJ2EE.annotation");
	Motor motor = context.getBean("motor",Motor.class);
	Engine engine = context.getBean("engine",Engine.class);
	System.out.println(engine);
	System.out.println(motor);
}
}
