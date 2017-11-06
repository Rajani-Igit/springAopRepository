package com.declarative.afteradvice.test;

import javax.crypto.KeyGenerator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.declarative.afteradvice.beans.KeyGenrator;

public class AOPDeclarativeAfterAdviceTest {
   public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/declarative/afteradvice/common/application-context.xml");
	KeyGenrator keyGenrator = context.getBean("keyGenrator",KeyGenrator.class);
	int len = keyGenrator.genrate(7);
	System.out.println("Genrated Key lenght is "+len);
}
}
