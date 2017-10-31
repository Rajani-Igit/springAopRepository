package com.afteradvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.afteradvice.beans.KeyAdvice;
import com.afteradvice.beans.KeyGenrator;

public class AfterAdviceTest {
   public static void main(String[] args) {
	ProxyFactory pf = new ProxyFactory();
	pf.setTarget(new KeyGenrator());
	pf.addAdvice(new KeyAdvice());
	KeyGenrator keyGenrator = (KeyGenrator)pf.getProxy();
	int keyGen = keyGenrator.genrator(9);
	System.out.println("Key is Genrated "+keyGen);
}
}
