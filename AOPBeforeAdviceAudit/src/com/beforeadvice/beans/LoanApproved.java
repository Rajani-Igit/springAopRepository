package com.beforeadvice.beans;

public class LoanApproved {
  public boolean approve(long serialNO) {
	  //some checks will be performed and returning some value based on some conditions
	  System.out.println("inside the approve method from LoanApproved class");
	  return true;
  }
}
