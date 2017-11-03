package com.dependson.annotation;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("cacheManager")
public class Cache {
   public Cache() {
	   System.out.println("Constructor from Cache class");
   }
   public void calculatedBil() {
	   System.out.println("This method calculated the bil ");
   }
}
