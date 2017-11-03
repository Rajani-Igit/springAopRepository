package com.stereo.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Station {
 private String name;
  public Station() {
   System.out.println("inside Station constructor");	 
}

public String getName() {
	return name;
}
//@Value("Songs Station")
@Value("#{radioProps.Station_name}")
public void setName(String name) {
	System.out.println("setName inside Station class "+name);
	this.name = name;
}
@Override
public String toString() {
	return "Station [name=" + name + "]";
}
}
