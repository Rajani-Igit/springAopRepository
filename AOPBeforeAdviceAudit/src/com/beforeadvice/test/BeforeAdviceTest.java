package com.beforeadvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.beforeadvice.beans.AuditingAdvice;
import com.beforeadvice.beans.LoanApproved;

public class BeforeAdviceTest {
   public static void main(String[] args) {
	ProxyFactory pf= new ProxyFactory();
	pf.setTarget(new LoanApproved());
	pf.addAdvice(new AuditingAdvice());
	LoanApproved loanApproved = (LoanApproved)pf.getProxy();
	loanApproved.approve(10045);
	System.out.println("End of the main Loan Got Approved");
}
}
