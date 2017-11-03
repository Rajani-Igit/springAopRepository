package com.propertysource.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceTest {
   public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext("com.propertysource.annotation");
	Radio radio = context.getBean("radio",Radio.class);
	System.out.println(radio);
}
}
