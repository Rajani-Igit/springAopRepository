package com.autowired1.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *Here There are multiple Usecases we have understand
 *1)We can write multiple constructors to initialize the robot class
 *with one condition is that required attribute inside @AutoWired have to make false
 *by default it is true
 *
 * 2)If you provide @AutoWired Annotation at setter method level but the coressponding
 * bean is not available in configuration file.then it will not create the Object 
 * to the Robot class Even though setter injection is optional
 * Why bcz By default its value is true
 * 
 * 3)In configuration Approach We have modes of auto wireing will be there There are
 * 4 modes of auto wireing will be there.but here we have only one way that is ByType
 * 
 *  4)If you configure the Two Beans in configuration file like chip1 and chip2 then IOC 
 *  Container dont know which bean to inject and this will leads to ambiguity
 *  this can be solved by using qualifier Annotation we have to provide the Qulifier name 
 *  insid ethe configuration file based on that we can it will inject the appropriate bean
 *  bydefault id is the qulifier name or if you are not writing any bean configuration file
 *  Class Name starting with small letter is consided as id
 */

public class Robot {
//At Attribute Level We can not apply at Constructor level
    @Autowired
	@Qualifier("chip1")
  private Chip chip;
  private int id;
  private String type;
  private Sensor sensor;
  
//At Constructor Level

   public Robot() {
	  System.out.println("Zero Arg Constructor of Roboat Class");
  }
  
	@Autowired(required=false)
   public Robot(Chip chip,Sensor sensor) {
	  this.sensor = sensor;
	  this.chip = chip;
	  System.out.println("inside the two arg constructor");
  }
  
	@Autowired(required=false)
	  public Robot(Chip chip) {
		  this.chip = chip;
		  System.out.println("inside Chip arg constructor");
	  }
	@Autowired(required=false)
	  public Robot(Sensor sensor) {
		  this.sensor = sensor;
		  System.out.println("inside Sensor arg constructor");
	  }
	
//At SetterMethod Level
//@Autowired(required=true)
public void setChip() {
	System.out.println("Setter method of Roboat");
	
}

@Override
public String toString() {
	return "Robot [chip=" + chip + ", id=" + id + ", type=" + type + "]";
}
public void setId(int id) {
	this.id = id;
}
public void setType(String type) {
	this.type = type;
}
}
