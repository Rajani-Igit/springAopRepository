package com.afteradvice.beans;

public class KeyGenrator {
public int genrator(int len) {
	System.out.println("Inside KeyGenrator Algoritham");
	if(len < 8) {
		return 0;
	}
	return 1;
}
}
