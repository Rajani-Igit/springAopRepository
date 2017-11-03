package com.bean.annotation;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/* There are situations we can not use configuration file And we can not use annotations
 * also bcz if the source code is not available with us and xml has its own drawbacks
 *  we should go for configuration file approach.We have to create one class that is 
 *  configuration class can be achived by providing tha @Configuration Annotation at class
 *  level.And declare the methods init each method will represent a configuration inside IOC
 *  Container
 *  This can be done by providing the @Bean Tag on top if it.And if that bean required any 
 *  dependency we have to provide autowire attribute inside the @Bean tag.we dont have
 *  any constructor injection here even if we have also we have to manage by our selfs
 *  Bcz here we are creating the objects to it.but if the bean is dependent on another bean
 *  weather it may be setter or field we can achive this by providing autowire Attribute 
 *  on top of it.Here only two ways are possible byName and ByType by default ByType
 *  But this is applicable only for Object as Dependency but incase of primitives we can not apply this
 *  you can not provide value annotation bcz source code is not there .you have to set manually
 *  but if you do those values are static or fixed.you can provide dynamic values by using PropertyResource Annotation
 *  And Declare the Environment Variable inside the class.so all the properties from properties file are 
 *  available as part of it so we can get it from environment variables directly
 *  
 * 
 */
@Configuration
@PropertySource("classpath:com/bean/annotation/robotProperties.properties")
public class AppConfig {
	@Autowired
    private Environment env;
	@Bean(autowire=Autowire.BY_TYPE)
	public Radio radio() {
		Radio radio = new Radio();
		radio.setFrequency(Integer.parseInt(env.getProperty("Radio_frequency")));
		radio.setStationName((env.getProperty("Radio_stationName")));
		
		//radio.setFrequency(Integer.parseInt("${Radio_frequency}"));
		//radio.setStationName(("${Radio_stationName}"));
		return radio;
	}
	
	@Bean
	public Chip chip() {
		Chip chip = new Chip();
		chip.setChipId(Integer.parseInt(env.getProperty("Chip_chipId")));
		chip.setChipType((env.getProperty("Chip_chipType")));
		return chip;
	}
}
