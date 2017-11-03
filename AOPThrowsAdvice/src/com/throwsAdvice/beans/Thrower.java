package com.throwsAdvice.beans;

public class Thrower {
  public void exceptionThrowing() {
	  System.out.println("inside afterThrowing exception from Thrower class");
	  throw new IllegalArgumentException();
  }
}
