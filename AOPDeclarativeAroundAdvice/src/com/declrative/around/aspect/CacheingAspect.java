package com.declrative.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.declrative.around.util.Cache;
//We are writing this class name as Aspect incase of programetic approach 
//we wrote class name as Advice class bcz if you write a class implementing from runnable then that class start behaving as 
//Thread class. similarly earlier we implemented a class from MethodInterceptor or some class then IOC Container will  know 
//or identify the This class is Advice class by looking at the implementing class.and it will identify the aspect in the advice class 
//also bcz we are implementing from some interface means we have to over ride that method inside that method we will provide 
//aspect logic so that IOC Container will identify
//But incase of Declarative approach we are not implementing from any interface so we have to write aour aspect class and inside that method
//we have to write a method that is advice method bcz we can not implement every method with aspect logic only few methods we will provide this logic
//so name this class as aspect class and method as advice method
public class CacheingAspect {
	private Cache cache;
	
	//We can write any method but it should same as or reflects the same signature as 
	//That advice
	//In this method we have to write out Advice logic
	
  public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	  
	  //We can get the information of Target class by MethodInvocation incase of Programetic Approach.but the problem with this approach is 
	  //we are thightly coupled with spring provided API.and our application will become Invasive inorder to avoid this using Java provided classes 
	  //But java did not provided any support for this AOP Approach but so AspectJ comes into picture.we have to use interface or class reference 
	  //references to it.to ease of devloping the applications.but if we use spring provided interfaces are classes our classes will be thightly coupled
	  //or invasive this can be replaced by Aspect J classes.Thats where we ccan use Aspect j Aop Approach or Devlopment 
	   String methodName = null;
	   Object[] args = null;
	   String key = null;
	   Object ret = null;
	   System.out.println("Entered into the cache adviser");
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
