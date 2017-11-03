package com.javaconfigJ2EE.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("ee") 
  @Named("engine")
public class Engine {
	
    private int engineId;
	
    private String engineName;
    
	public Engine() {
		System.out.println("Engine Constructor called");
	}
	
	@PostConstruct
	public void init() {
    System.out.println("Init method or Post Construct method from Engine class");
	}
   
	@Value("10")
    public void setEngineId(int engineId) {
	System.out.println("setEngineId method from Engine class");
	this.engineId = engineId;
    }
    
    public int getEngineId() {
	return engineId;
    }
    
    @Value("HondaEngine")
    public void setEngineName(String engineName) {
    System.out.println("SetEngineName method from Engine class");
	this.engineName = engineName;
    }

    public String getEngineName() {
	return engineName;
    }

    @Override
	public String toString() {
		return "Engine [engineId=" + engineId + ", engineName=" + engineName + "]";
	}

    @PreDestroy
    public void release() {
	 System.out.println("Destroy method or preDestroy method from Engine");
    } 
}
