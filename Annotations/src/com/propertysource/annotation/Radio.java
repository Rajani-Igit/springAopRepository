package com.propertysource.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/* @PropertySource Annotation is used to provide the dynamic values to the
 * primitive type attributes by reading those from properties file
 * we can achieve these by using stereo type annotations but if you go with PropertySource
 * annotation you can completely avoid configuration file.
 * earlier we are reading  from properties file and we try to place that properties
 * object inside of that IOC Container by using that object we can get the properties information
 * But incase of PropertySource we can directly get those properties information inside
 * our class directly 
 * By using Spring expression language we can directly assign those values to the variables
 * So no need to write Spring Bean Configuration file
 * Incase of PropertySource we have to provide the location of the property file
 * This annotation is applicable at only class level annotation
 * By using expression language we can read those values from properties file
 * Acctually those values are stored inside the Environment variable of IOC Container
 * Environmnet is a class like system JDK
 * if you want you can place those things inside System class also
 * But incase of Environment it will be taking care of every thing whenever you are 
 *  requesting property it will search in Environment properties it will gives you
 * 
 */
@Component
@PropertySource("classpath:com/propertysource/annotation/radio.properties")
public class Radio {
	
	/*@Autowired
	Environment env;*/
	
	@Value("${radioId}")
	private int radioId;
    
	/*@Value("${radioId}")
	public void setInt(String radioId) {
		System.out.println("inside setter");
		this.radioId = Integer.parseInt(radioId); 
	}*/
    
	@Value("${stationName}")
    private String stationName;
  
	public Radio() {
		System.out.println("Radio constructor created");
	}
	
  public void setRadioId(int radioId) {
	this.radioId = radioId;
  }
  public void setStationName(String stationName) {
	this.stationName = stationName;
  }
@Override
public String toString() {
	//System.out.println("Environment Variable   "+env.getProperty("stationName"));
	return "Radio [radioId=" + radioId + ", stationName=" + stationName + "]";
}
   
}
