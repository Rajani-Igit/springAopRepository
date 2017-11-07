package com.annotation.before.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.annotation.before.util.AuthenticationManager;

/**
 * @Component Annotation is usefull to make this class as bean inside the IOC Container 
 * bcz Here we are trying to avoid Configurationfile completely.Insted of that we can use this stereio type annotation
 * 
 * @Aspect Annotation Makes this class contain logic as Aspect 
 * 
 * @Order Annotation will help you in applying crosscutting logic order.
 */
/*@Component("authenticationAspect")
@Aspect
@Order(2)*/
public class AuthenticationAspect {
	  
	    private AuthenticationManager authenticationManager;
	  
	    public AuthenticationManager getAuthenticationManager() {
			return authenticationManager;
		 }
		 
		 @Autowired
		 public void setAuthenticationManager(AuthenticationManager authenticationManager) {
			 System.out.println("Inside AuthenticationAspect setter Method through Autowired ");
			this.authenticationManager = authenticationManager;
		}
	  
	  /*Particular Method This PCD will be applicable*/
	  //@Before(value="execution(* com.annotation.before.beans.LoanManager.approve(String))")
	   
	  
	   /*For A Particular class Type it will be Applicable(It will compare by Class Types References)*/
	   //@Before(value="target(com.annotation.before.beans.LoanManager)")
		
	   /*For A Particular class Type it will be Applicable(It will compare by Class Names with help of regular expressions)*/	
	   //@Before(value="within(com.annotation.before.beans.LoanManager)")
	  
	   /*For A Particular Object Type it will be Applicable(It will compare Two Object type references)*/
	   //@Before(value="this(com.annotation.before.beans.LoanManager)")
	    
	    @Before("target(com.annotation.before.beans.LoanManager)")
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
}
