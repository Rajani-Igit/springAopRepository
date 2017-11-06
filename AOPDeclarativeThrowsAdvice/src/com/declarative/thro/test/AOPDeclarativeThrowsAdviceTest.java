package com.declarative.thro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.declarative.thro.beans.Thrower;

public class AOPDeclarativeThrowsAdviceTest {
   public static void main(String[] args) {
   ApplicationContext context = new ClassPathXmlApplicationContext("com/declarative/thro/common/application-context.xml");
   Thrower thrower = context.getBean("thrower",Thrower.class);
   thrower.willThrow("exception");
   System.out.println("End of the main method");
}
}
