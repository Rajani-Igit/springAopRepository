package com.annotation.before.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *To eliminate the complete Configuration file we should go for JavaConfigration file
 *And few more reasons i already explained in Spring Core Annotations
 *
 *@Configuration Makes this class as global configuration file insted of defineing Spring BeanConfiguration file
 *
 *@EnableAspectJAutoProxy is useful for Enabling all the aspects throughout our application.bcz @Aspect we may defined in multiple classes
 *in Multiple Beans.to make those classes as Aspect classes.in order to make those classes as aspec classes without implementing Provided interfaces and
 *without writing spring BeanConfiguration file we can achive by using Annotations
 *
 *case 1:-
 *    If you write Annotations(Stereio and Aspect) And you are using ClassPathXmlApplicationContext it will take Configration file
 *    in that senario we are not writing configuration information of the class.we are just writing context:component scan and auto-proxy enabled
 *    so that spring will understand that we are providing configration information in the form of Annotations
 *    Here the Base packages names should be seprated by comma
 *case 2:-
 *    If you are writing the Annotations and you are completely avoiding the configuration file we can achive this by writing the AnnotationConfigApplicationContext
 *    but it is ok incase of Spring Annotations bcz it will search in each and every class for stereio type annotations and it will instanstiate the classes as beans
 *    but in case of aspect j we can not achieve this bcz some global configration is required i.e aop:auto-proxy enabled to make beans as aspects inside ioc container
 *    for this we need to provide global configuration.but we are not using configuration file.insted of that we can go for JavaConfiguration Approach
 *    so that we can provide this class as argument to AnnotationConfigere class we have write below annotaions  
 *    h   
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.annotation.before.beans","com.annotation.before.aspect","com.annotation.before.util"})
public class GlobalApplicationConfig {

}
