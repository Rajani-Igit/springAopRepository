package com.declrative.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public Object log(ProceedingJoinPoint pjp) {
		String methodName = null;
		Object[] args = null;
		Object currentObj = null;
		Object ret = null;
		methodName = pjp.getSignature().getName();
		args = pjp.getArgs();
		currentObj = pjp.getThis();
		//Here Just Trying to modify the values
		args[0] = (Integer)args[0]+10;
		args[1] = (Integer)args[1]+10;
		System.out.println("entered into the "+methodName+"("+args[0]+" ,"+args[1]+")");
		try {
			//The modified values are not reflected here for no arg proceed method
			//Modified Values are applicable for argument methods
			ret = pjp.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//Modified return value is this changes will be appear with out  any modification
		ret =(Integer)ret +10;
		System.out.println("Exiting from the "+methodName+" and retun value is "+ret);
		return ret;
	}

}
