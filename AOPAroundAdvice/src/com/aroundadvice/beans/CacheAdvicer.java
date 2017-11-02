package com.aroundadvice.beans;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aroundadvice.util.Cache;

public class CacheAdvicer implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("enterd into the CacheAdviser invoke method");
		String methodName = null;
		Object[] args = null;
		String key = null;
		Object ret = null;
		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		key = methodName+"(";
		for(int i=0;i<args.length;i++) {
			if(i == 0) {
				key +=args[i];
				continue;
			}
			key += ","+args[i];
		}
		key +=")";
		System.out.println("Genrated key is "+key);
		Cache cache = Cache.getInstance();
		if(cache.containsKey(key)== true) {
			 ret = cache.get(key);
			 return ret;
		}
		ret = methodInvocation.proceed();
		cache.put(key, ret);
		System.out.println("return value is "+ret); 
		System.out.println("exiting from the CacheAdvicer invoke method");
		return ret;
	}

}
