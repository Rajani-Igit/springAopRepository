package com.staticpointcut.beans;

public class Calculator {
	public Calculator() {
		System.out.println("Calculator Constructor called");
	}
  public int add(int a ,int b) {
	  System.out.println("add() method from Calculator");
	  return a+b;
  }
  public int multiply(int a , int b) {
	  System.out.println("multiply() method from Calculator");
	  return a*b;
  }
}
