package com.declarative.afteradvice.beans;

public class KeyGenrator {
   public int genrate(int len) {
	   if(len <= 7) {
		   System.out.println("inside the KeyGenrator class genrate method");
		   return 0;
	   }
	   return 1;
   }
}
