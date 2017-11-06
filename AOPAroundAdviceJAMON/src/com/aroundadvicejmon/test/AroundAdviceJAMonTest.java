package com.aroundadvicejmon.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aroundadvicejmon.beans.LoanCalculator;
import com.aroundadvicejmon.beans.PerformenceAdvice;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class AroundAdviceJAMonTest {
   public static void main(String[] args) throws Exception{
   ProxyFactory factory = new ProxyFactory();
   factory.setTarget(new LoanCalculator());
   factory.addAdvice(new PerformenceAdvice());
   LoanCalculator loanCalculator =(LoanCalculator)factory.getProxy();
   float intrestRate = loanCalculator.loanPlanner(1000,"Hyderabad",12);
   System.out.println(intrestRate);
   }
}
