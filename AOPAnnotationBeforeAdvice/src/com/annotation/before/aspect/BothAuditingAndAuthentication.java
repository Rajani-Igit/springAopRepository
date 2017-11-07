package com.annotation.before.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.annotation.before.util.AuthenticationManager;

/**
 *We can use either use two class Approach by uncommenting that three class level Annotations on the classes
 *or else we can use BothAuditingAndAuthentication class
 */
@Component
@Aspect
@Order
public class BothAuditingAndAuthentication {
	
	    private AuthenticationManager authenticationManager;
	  
	    public AuthenticationManager getAuthenticationManager() {
			return authenticationManager;
		 }
		 
		 @Autowired
		 public void setAuthenticationManager(AuthenticationManager authenticationManager) {
			 //System.out.println("Inside AuthenticationAspect setter Method through Autowired ");
			this.authenticationManager = authenticationManager;
		}
		 
		 /*if we have multiple methods with same aspect logic with in the same class writing the same pointcut logic across all the class is not good
		  * insted of that we can write a method at the sam class level and write that same pointcut logic on top of that method and we can reuse the
		  * functionality
		  * Same as we write in around advise usecase.there we have written that logic inside a class bcz that logic will be useful in several classes in
		  * the application.but here we are writing inside a single class single method bcz it will be usefull in several methods of tha same class
		  * */
		 
		 @Pointcut("target(com.annotation.before.beans.LoanManager)")
		 public void commonPointCut() {
		   System.out.println("common point cut logic");	 
		 }
	  
	                     /*-------------------Authentication Logic--------------------*/
		 
		 
	    /*Particular Method This PCD will be applicable*/
	   //@Before(value="execution(* com.annotation.before.beans.LoanManager.approve(String))")
	   
	   /*For A Particular class Type it will be Applicable(It will compare by Class Types References)*/
	   //@Before(value="target(com.annotation.before.beans.LoanManager)")
		
	   /*For A Particular class Type it will be Applicable(It will compare by Class Names with help of regular expressions)*/	
	   //@Before(value="within(com.annotation.before.beans.LoanManager)")
	  
	   /*For A Particular Object Type it will be Applicable(It will compare Two Object type references)*/
	   //@Before(value="this(com.annotation.before.beans.LoanManager)")
	    
	   // @Before("target(com.annotation.before.beans.LoanManager)")
		 @Before("commonPointCut()")
	    @Order(1)
	    public void security(JoinPoint joinPoint) {
		  String methodName = null;
		  Object[] args = null;
		  methodName = joinPoint.getSignature().getName();
		  args = joinPoint.getArgs();
		  System.out.println(authenticationManager.userInfo.getUserName()+" acessing the method "+methodName+"("+args[0]+")");
		 /* if(authenticationManager.userInfo.getUserName().equals("sairam") == false) {
			  throw new IllegalArgumentException("provide valid userid and password");
		  }*/
		  if(authenticationManager.authenticate()) {
			  throw new IllegalArgumentException("provide valid userid and password");
		  }
	  }
	    
	                     /*-------------------Auditing Logic--------------------*/
	    
	       /*Particular Method This PCD will be applicable*/
		   //@Before(value="execution(* com.annotation.before.beans.LoanManager.approve(String))")
		   
		  
		   /*For A Particular class Type it will be Applicable(It will compare by Class Types References)*/
		   //@Before(value="target(com.annotation.before.beans.LoanManager)")
			
		   /*For A Particular class Type it will be Applicable(It will compare by Class Names with help of regular expressions)*/	
		   //@Before(value="within(com.annotation.before.beans.LoanManager)")
		  
		   /*For A Particular Object Type it will be Applicable(It will compare Two Object type references)*/
		   //@Before(value="this(com.annotation.before.beans.LoanManager)")
		    
	    //@Before("target(com.annotation.before.beans.LoanManager)")
	    @Before("commonPointCut()")
	    @Order(2)
	    public void audit(JoinPoint joinPoint) {
		String methodName = null;
		Object[] args = null;
		methodName = joinPoint.getSignature().getName();
		args = joinPoint.getArgs();
		System.out.println("inside the AuditingAspect class from ");
		System.out.println(authenticationManager.userInfo.getUserName()+" is calling the "+methodName+"("+args[0]+")");
	   }
}
