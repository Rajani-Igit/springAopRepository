package com.annotation.around.beans;

public class Calculator {
  
	public int add(int a ,int b) {
	  System.out.println("inside the add method of Calculator class");
	  return a+b;
    }
    
    public int multiply(int a ,int b) {
    	System.out.println("inside the multiplay method of Calculator class");
    	return a*b;
    }
}
