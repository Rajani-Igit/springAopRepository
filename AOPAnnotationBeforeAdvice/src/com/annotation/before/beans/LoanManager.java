package com.annotation.before.beans;

import org.springframework.stereotype.Component;

@Component("loanManager")
public class LoanManager {
	 public boolean approve(String loanNo) {
		   System.out.println("inside the LoanManager class Approve method");
		   return true;
	   }
}
