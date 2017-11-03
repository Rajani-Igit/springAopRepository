package com.dependson.annotation;

import org.springframework.stereotype.Component;

@Component
public class CacheManager {
   public CacheManager() {
	   System.out.println("CacheManager class Constructor");
	   load();
   }
   public void load() {
	   System.out.println("Data loaded into cache class sucessfully");
   }
}
