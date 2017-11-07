package com.annotation.thro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*These three annotations are helps in makeing a class as global configuration class*/

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages= {"com.annotation.thro.aspect","com.annotation.thro.beans"})
public class GlobalApplicationConfig {

}
