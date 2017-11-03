package com.bean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.autowired.annotation.Robot;

public class BeanTest {
  public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	Radio radio = context.getBean("radio",Radio.class);
	System.out.println(radio);
}
}
