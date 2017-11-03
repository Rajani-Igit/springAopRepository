package com.dymamicpointcut.beans;

public class Calculator {
	public Calculator() {
		System.out.println("Calculator constructor will be called");
	}
   public int add(int a, int b) {
	   System.out.println("inside the add method from Calculator");
	   return a+b;
   }
   public int multiply(int a, int b) {
	   System.out.println("inside the multiplay method from Calculator");
	   return a*b;
   }
}
