package com.declarative.before.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.declarative.before.beans.LoanManager;
import com.declarative.before.util.AuthenticationManager;



public class DeclarativeBeforeAdviceTest {
   public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/declarative/before/common/application-context.xml");
	AuthenticationManager authenticationManager = context.getBean("authenticationManager", AuthenticationManager.class);
	authenticationManager.login("sairam", "welcome");
	LoanManager loanManager = context.getBean("loanManager",LoanManager.class);
	boolean approve = loanManager.approve("123456");
	System.out.println("Loan Approved "+approve);
}
}
