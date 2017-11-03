package com.scope.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ToyTest {
   public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/scope/annotation/application-context.xml");
    /*Toy toy1 = context.getBean("toy10",Toy.class);
    Toy toy2= context.getBean("toy10",Toy.class);
    System.out.println("first Bean Hashcode is "+toy1.hashCode());
    System.out.println("second Bean Hashcode is "+toy2.hashCode());
    System.out.println( toy1 == toy2?true:false);*/
}
}
