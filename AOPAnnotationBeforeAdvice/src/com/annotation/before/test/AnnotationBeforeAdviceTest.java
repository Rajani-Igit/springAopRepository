package com.annotation.before.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.annotation.before.beans.LoanManager;
import com.annotation.before.config.GlobalApplicationConfig;
import com.annotation.before.util.AuthenticationManager;

public class AnnotationBeforeAdviceTest {
   public static void main(String[] args) {
	   
	    ApplicationContext context = new AnnotationConfigApplicationContext(GlobalApplicationConfig.class);
	    //ApplicationContext context = new ClassPathXmlApplicationContext("com/annotation/before/common/application-context.xml");
		AuthenticationManager authenticationManager = context.getBean("authenticationManager", AuthenticationManager.class);
		authenticationManager.login("sairam", "welcome");
		LoanManager loanManager = context.getBean("loanManager",LoanManager.class);
		boolean approve = loanManager.approve("123456");
		System.out.println("Loan Approved "+approve);
}
}
