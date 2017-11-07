package com.annotation.thro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.annotation.thro.beans.Thrower;
import com.annotation.thro.config.GlobalApplicationConfig;

public class AOPAnnotationThrowsAdviceTest {
   public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(GlobalApplicationConfig.class);
	Thrower thrower = context.getBean("thrower", Thrower.class);
	thrower.willThrow("throwing exception wantedly");
}
}
