package com.annotation.thro.beans;

import org.springframework.stereotype.Component;

@Component("thrower")
public class Thrower {
 public void willThrow(String name) {
	 System.out.println("inside willThrow exception from Thrower class");
	  throw new IllegalArgumentException("we are throwing this exception wantedly");
 }
}
