package com.afteradvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.afteradvice.beans.NetworkPlans;
import com.afteradvice.beans.SMSPlanProvider;

public class AfterAdviceTest {
   public static void main(String[] args) {
	ProxyFactory pf = new ProxyFactory();
	pf.setTarget(new NetworkPlans());
	pf.addAdvice(new SMSPlanProvider());
	NetworkPlans newtworkPlans = (NetworkPlans)pf.getProxy();
	newtworkPlans.recharge("9701136377",100);
	System.out.println("end of the main method");
}
}
