package com.lookup.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RequestHandler {
  public RequestHandler() {
	  System.out.println("RequestHandler Constructor");
  }
  public String serviceProvider(String data) {
	  return data;
  }
  
}
