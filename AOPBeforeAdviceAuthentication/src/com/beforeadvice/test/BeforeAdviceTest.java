package com.beforeadvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.beforeadvice.beans.AuditingAdvice;
import com.beforeadvice.beans.AuthenticationManager;
import com.beforeadvice.beans.LoanApproved;
import com.beforeadvice.beans.SecurityAdvice;

public class BeforeAdviceTest {
   public static void main(String[] args) {
	ProxyFactory pf= new ProxyFactory();
	pf.setTarget(new LoanApproved());
	pf.addAdvice(new AuditingAdvice());
	pf.addAdvice(new SecurityAdvice());
	AuthenticationManager authenticationManager = AuthenticationManager.getInstance();
	authenticationManager.login("sairam", "welcome");
	LoanApproved loanApproved = (LoanApproved)pf.getProxy();
	loanApproved.approve(10045);
	System.out.println("End of the main Loan Got Approved");
}
}
