package com.declarative.thro.beans;

public class Thrower {
 public void willThrow(String name) {
	 System.out.println("inside willThrow exception from Thrower class");
	  throw new IllegalArgumentException();
 }
}
