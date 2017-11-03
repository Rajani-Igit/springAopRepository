package com.lookup.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/*  Lookup Method injection is useful when you are trying to inject prototype
 *  object into singleton object so that prototype object starts will 
 *  behaving like singleton object so there are areas  that dependency injection 
 *  is not upto the mark.Still the space is available in dependency injection
 *  Most of the beans are singletons only so For Target class only one object 
 *  will be created
 *  So if you go for constructor or setter or aware interface injection only 
 *  one object will be created even though it is prototype bean
 *    1) So if we go for dependency pull there are certain problems are there
 *   --> we are tightly coupling with the Target class name.and my class should know 
 *       complete instanstiation logic of that class
 *   --> If you go for Aware interface injection we can avoid this problem but 
 *       my classes should become invasive
 *   --> To avoid such problems we should go for lookup method injection
 *   --> For this we have to write a method inside a class.return type of the method should be 
 *       same as the class we want to inject and return null
 *   --> Bcz we are not instanstiating the class we just will give this class to IOC Container IOC 
 *       Container will inject htis class
 *   --> So when ever you requested this class for Object it will give prototype object
 *       We can achieve this by using Annotation Driven Approach also by using @DependsOn
 *       We can apply at method level
 */

@Component
public class Container {
	
	private RequestHandler requestHandler;
	
   public Container() {
	   System.out.println("Container constructor");
   }
  @Lookup
   public RequestHandler getRequestHandler() {
	   System.out.println("This is look up method");
	   return null;
   }
   public void service(String data) {
	   
	   requestHandler = getRequestHandler();
	   System.out.println("requestHandler Objects HashCodes  "+requestHandler.hashCode());
	   String providedData = requestHandler.serviceProvider(data);
	   System.out.println("Providded Data  "+providedData);
   }
}
