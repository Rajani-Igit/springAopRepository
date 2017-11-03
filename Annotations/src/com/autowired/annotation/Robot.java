package com.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *We can Place AutoWired in 4 places in our application
 *   At Attribute Level
 *   Bcz I Dont Want to perform any PostProcessing Logic and I dont want to modify Any thing
 *   Inside The Object So Better to go with Attribute Level
 *   This will be injected with out calling constructor and setter IOC Container 
 *   directly will asign the value to it.Even it is Private also
 *   
 *At Constructor Level
 *If you want to perform any pot processing logic we should go for this
 *
 *At Setter Method Level
 *If you want to modify the object before processing this we should go for This level
 *
 *At An Orbitary Method Level
 *Apart from this we can write this at an orbitary method level also
 *After performing constructor,setter,aware injection this method will be called by ioc container
 */
public class Robot {
//At Attribute Level
//@Autowired
  private Chip chip;
  private int id;
  private String type;
  
//At Constructor Level
//	@Autowired
  public Robot() {
	  //this.chip = chip;
	  System.out.println("Constructor of Roboat Class");
  }
  
//At SetterMethod Level
@Autowired
public void setChip(Chip chip) {
	System.out.println("Setter method of Roboat");
	this.chip = chip;
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
