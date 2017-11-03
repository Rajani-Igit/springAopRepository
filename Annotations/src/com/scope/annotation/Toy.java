package com.scope.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *@Scope Annotation is used to provide the scope of the bean inside the IOC Container 
 *By Default it is single ton if you want to make it as Prototype we can do it by
 *using Scope Type.This Annotation can be applied at Method and Class level
 *
 *@Component(String) can be used for customizing the bean defination by default it 
 *will be created with the class name starting from small letter and subsequent letters 
 *are capital 
 *
 *@Lazy annotation is used for instanstiating the Bean when and  ever you want
 *Bcz Annotation support is not possible with BeanFactory so we have to use Application
 *Context it will provide the support for annotations
 *But ii will instantiate the EveryBean at the time of creating the IOC Container
 *So if you want to create a Bean when ever you requested you can Achieve this by using
 *This Annotation And this can be applicable at Method and Class Level
 *By default ApplicationContext will initializes all the beans which are all singletons 
 *Bcz there is no particular scope is available with them
 */
@Component("toy10")
@Scope
@Lazy(false)
public class Toy {
	
	public Toy() {
		System.out.println("constructor hasbeen called");
	}
	@Value("10")
private int toyId;
	@Value("Plastic Toy")
private String toyType;
public void setToyId(int toyId) {
	this.toyId = toyId;
}
public void setToyType(String toyType) {
	this.toyType = toyType;
}

@Override
public String toString() {
	return "Toy [toyId=" + toyId + ", toyType=" + toyType + "]";
}
}
