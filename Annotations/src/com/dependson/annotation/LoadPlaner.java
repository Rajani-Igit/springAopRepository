package com.dependson.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/*  DependsOn Annotation is used to create the Object of Target class 
 * dependent before creating the Target class Object
 * This can be achieved by @DependsOn Annotation
 * This we can apply at class level and method level also 
 */
@Component

public class LoadPlaner {
	
	public LoadPlaner() {
		System.out.println("LoadPlanner constructor ");
	}
	private Cache cache;
	public Cache getCache() {
		return cache;
	}
	@Autowired
	public void setCache(Cache cache) {
		System.out.println("setter for cache object from LoiadPlanner");
		this.cache = cache;
	}
	public void calculate(double principleAmount,int tenure,String place) 
	{
		System.out.println("calculate Method from Load Planner class");
		cache.calculatedBil();
	}
}
