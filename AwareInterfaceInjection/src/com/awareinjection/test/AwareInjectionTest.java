 package com.awareinjection.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.awareinjection.beans.Car;

public class AwareInjectionTest {
  public static void main(String[] args) {
	BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com//awareinjection//common//application-context.xml"));
	System.out.println("IOC Container  "+factory.hashCode());
	Car car = factory.getBean("car",Car.class);
	car.drive();
}
}
