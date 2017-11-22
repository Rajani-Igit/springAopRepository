package com.awareinjection.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Car implements BeanFactoryAware{
	private Engine engine;
	private BeanFactory factory;
    
    public void drive() {
    	System.out.println("inside drive method");
    	
    	
    	/**
         *  We should not create one more BeanFactory once again bcz in the environmrnt where car is created in the same environment
         *  only HondaEngine and YamahaEngine is created if you create it one more time memory will be waste.
         *  The way servlet will get context by config but config object will be provided as part of contract between container and programer that is nothing 
         *  but contextal dependency lookup  
         */
    	
    	
    	/*BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com//awareinjection//common//application-context.xml"));
    	System.out.println("IOC Container "+factory.hashCode());
    	engine = factory.getBean("hondaEngine", Engine.class);
    	engine.start();
    	System.out.println("drive the car now!");*/
    	
    	System.out.println("IOC Container "+factory.hashCode());
    	engine = factory.getBean("hondaEngine", Engine.class);
    	engine.start();
    	System.out.println("drive the car now!");
    }
    /**
     * This is the contract method will be provided by BeanFactoryAware
     *
     */
	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("setBeanFactory method will be called");
    this.factory=factory;		
	}
	
	
}
