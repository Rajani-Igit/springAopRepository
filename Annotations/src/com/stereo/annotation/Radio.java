package com.stereo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *Sterio Tags are the Tags are used as alternative way of providing the configuration information
 *in the IOC Container with out writing the configuration information of a class 
 *in spring bean configuration file we can place the beans inside IOC container These are class 
 *level Tags 
 *
 *@Value Tags are used for providing the values for Attributes inside a class
 *These can be placed at method level or attribute level also.But insted of hard codeing the
 *values we can provide them dynamically reading from properties file 
 *with help of spring expression language

 */
@Component
public class Radio {
  //@Value(value="108")
	@Value("#{radioProps.Radio_frequency}")
  private int frequency;
	
  //@Value("108Music Chanel")
	
  private String chanelName;

  private Station station;
   
  /*private int val;
  @Autowired(required=false)
  public Radio(@Value("10")int val) {
	  System.out.println("inside Radio con "+val);
     this.val = val;	  
  }*/
  
  public Radio() {
	  System.out.println("default constructor of radio ");
  }
	
public void setFrequency(int frequency) {
	System.out.println("setFrequency in Radio class");
	this.frequency = frequency;
}
@Value("#{radioProps.Radio_chanelName}")
public void setChanelName(String chanelName) {
	System.out.println("setChanel in Radio class "+chanelName);
	this.chanelName = chanelName;
}

@Override
public String toString() {
	return "Radio [frequency=" + frequency + ", chanelName=" + chanelName + ", station=" + station + "]";
}
@Autowired
public void setStation(Station station) {
	System.out.println("Station setter in Radio class");
	this.station = station;
}
}
