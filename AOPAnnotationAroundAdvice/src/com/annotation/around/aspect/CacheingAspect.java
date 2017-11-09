package com.annotation.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import com.annotation.around.util.Cache;
import com.annotation.around.util.CommonAspect;

@Aspect
@Order(1)
public class CacheingAspect extends CommonAspect {
	private Cache cache;
    public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	  /*Particular Method This PCD will be applicable*/
	  //@Around(value="execution(* com.annotation.around.beans.Calculator.add(int,int))")
	  
	  
	   /*For A Particular class Type it will be Applicable(It will compare by Class Types References)*/
	   //@Around(value="target(com.annotation.around.beans.Calculator)")
		
	   /*For A Particular class Type it will be Applicable(It will compare by Class Names with help of regular expressions)*/	
	   //@Around(value="within(com.annotation.around.beans.Calculator)")
	  
	   /*For A Particular Object Type it will be Applicable(It will compare Two Object type references)*/
	   //@Around(value="this(com.annotation.around.beans.Calculator)")
	
	    /*if you want to apply the args pcd, we can not achieve this by writing common pcd by extending from an abstract class and writing the 
	     * pcd over the method.we can achive this by writing at the individual
	     *  */
       //@Around(value="common()")
	     @Around(value="execution(* com.annotation.around.beans.Calculator.add(..)) && args(k,l,m)" ) 
    public Object cache(ProceedingJoinPoint proceedingJoinPoint,int k,int l,int m) throws Throwable {
	  
	   String methodName = null;
	   Object[] args = null;
	   String key = null;
	   Object ret = null;
	   System.out.println("Entered into the cache aspect");
	   methodName = proceedingJoinPoint.getSignature().getName();
	   args = proceedingJoinPoint.getArgs();
	   key = methodName+"(";
	   for(int i=0;i<args.length;i++) {
		  if(i == 0) {
			  key +=args[0];
			  continue;
		  }
		  key +=","+args[i];
	   }
	   key +=")";
	   System.out.println("Key is "+key);
		if(cache.containsKey(key)== true) {
			 ret = cache.get(key);
			 return ret;
		}
		ret = proceedingJoinPoint.proceed();
		cache.put(key, ret);
		System.out.println("exiting from the cacheAspect and return value is "+ret);
		return ret;
  }
}
