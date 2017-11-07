package com.annotation.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import com.annotation.around.util.CommonAspect;

/**
 * This Aspect class and Cacheing Aspect class contains common pcd or Pointcut so insted of declaring two times inside the 
 * two different classes we are taking a abstract class and writing this pointcut on top a method.
 * And let your class extend from that abstract class and provice that method 
 */
@Aspect
@Order(2)

public class LoggingAspect extends CommonAspect {
   /*Particular Method This PCD will be applicable*/
   //@Around(value="execution(* com.annotation.around.beans.Calculator.add(int,int))")
   
   /*For A Particular class Type it will be Applicable(It will compare by Class Types References)*/
   //@Around(value="target(com.annotation.around.beans.Calculator)")
	
   /*For A Particular class Type it will be Applicable(It will compare by Class Names with help of regular expressions)*/	
   //@Around(value="within(com.annotation.around.beans.Calculator)")
  
   /*For A Particular Object Type it will be Applicable(It will compare Two Object type references)*/
   //@Around(value="this(com.annotation.around.beans.Calculator)")
	
	@Around(value="common()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) {
	  String methodName = null;
		Object[] args = null;
		Object currentObj = null;
		Object ret = null;
		methodName = proceedingJoinPoint.getSignature().getName();
		args = proceedingJoinPoint.getArgs();
		currentObj = proceedingJoinPoint.getThis();
		
		//Here Just Trying to modify the values
		args[0] = (Integer)args[0]+10;
		args[1] = (Integer)args[1]+10;
		System.out.println("entered into the "+methodName+"("+args[0]+" ,"+args[1]+")");
		try {
			
			//The modified values are not reflected here for no arg proceed method
			//Modified Values are applicable for argument methods
			//ret = proceedingJoinPoint.proceed(args);
			ret = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//Modified return value is this changes will be appear with out  any modification
		ret =(Integer)ret +10;
		System.out.println("Exiting from the "+methodName+" and retun value is "+ret);
		return ret;
	}

}
