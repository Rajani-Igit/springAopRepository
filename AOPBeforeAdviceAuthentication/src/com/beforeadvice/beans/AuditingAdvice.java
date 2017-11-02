package com.beforeadvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class AuditingAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = null;
		methodName = method.getName();
		String userName = null;
		userName = AuthenticationManager.getInstance().userInfo.getUserName();
		System.out.println("Entered into the before method from AuditAdvice class ");
		System.out.print(userName +" is trying to call  "+methodName +"(");
		for(int i=0;i<args.length;i++) {
			if(i == 0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print(", "+args[i]);
		}
		System.out.println(")");
	}
    
}
