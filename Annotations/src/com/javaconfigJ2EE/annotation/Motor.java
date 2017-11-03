package com.javaconfigJ2EE.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*  These Annotations are j2ee specific annotations .we can achive the same things by using this
 *  advantage of using this annotations over spring provided annotations is we can completely 
 *  remove spring also our application is going to work 
 * 
 *  @Inject annotation is used to inject the dependent values to target class.
 *  This will inject the dependent values always byTYpe.
 *  We can apply this annotation at constructor,field,method level
 *  This annotation will perform the same way as @Autowired.but incase of Autowired 
 *  it will take required attribute as parameter it a boolen type
 *  Where as @Inject Annotation will not take anything as parameter
 * 
 *  @Named Annotation Can be used to specify the name of the dependent beans while injecting
 *  The functionality is similar to @Qualifier bcz @Inject always will inject the values by
 *  Type.if two beans are there of same type in such conditin we should use @Named Annotation
 *  by specifying the particular bean defination we want to inject 
 *  
 *  This annotation can be also used for making the bean inside the IOC Container as bean
 *  If you declare like Stereo type annotation that class will act as bean defination inside IOC 
 *  Container.it is like @Component
 * 
 *  @Resource Annotation is used as @Inject Annotation but incase of Inject Annotation
 *  it will inject the dependent values byType but incase of @Resource Annotation it will inject the 
 *  dependent values byName
 *  
 *  @PostConstruct Annotation is used for postConstruction logic like we have lifecycle
 *  event methods so the same thing we can acheive by using Annotations also.for an orbitary method
 *  we can write this Annotation on top of it then this method will be called by underlying
 *  container performing the post construction logic 
 *  
 *  @PreDestroy Annotation is used for performing the preDestruction logic like we have 
 *  life cycle methods init() and destroy() methods we have to write @PostDestroy Annotation on top 
 *  so this method will be called after destroying all the single tons
 */

//@Component
  @Named
public class Motor {
   
	  
   private Engine engine;
   private String motorType;
   
   public Motor() {
		 System.out.println("Motor Constructor called");
	 }
   
   @PostConstruct
   public void init() {
	   System.out.println("Init method or Post Construct method from Motor class");
   }
   
  //@Inject
  //@Named("engine143")
    @Resource
 public void setEngine(Engine engine) {
	 System.out.println("Engine Value Setter method from Motor is called ");
	this.engine = engine;
 }
   
 public Engine getEngine() {
    	return engine;
 }
 
 @Value("Petrol Type")
 public void setMotorType(String motorType) {
	 System.out.println("Motor Type Setter Method in Motor class "+motorType);
	this.motorType = motorType;
 }
 
 public String getMotorType() {
		return motorType;
	 }
 
 @Override
 public String toString() {
 	return "Motor [engine=" + engine + ", motorType=" + motorType + "]";
 }
 
 @PreDestroy
 public void release() {
	 System.out.println("Destroy method or preDestroy method from Motor");
 }
}
