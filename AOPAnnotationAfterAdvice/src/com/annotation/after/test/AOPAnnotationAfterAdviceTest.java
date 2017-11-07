package com.annotation.after.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.annotation.after.beans.KeyGenrator;
import com.annotation.after.config.GlobalJavaConfig;

public class AOPAnnotationAfterAdviceTest {
   public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(GlobalJavaConfig.class);
	KeyGenrator keyGenrator = context.getBean("keyGenrator",KeyGenrator.class);
	int sum = keyGenrator.genrate(9);
	System.out.println("final return sum is  "+sum);
}
}
