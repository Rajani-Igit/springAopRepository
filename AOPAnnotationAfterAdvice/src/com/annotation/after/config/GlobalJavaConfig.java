package com.annotation.after.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages= {"com.annotation.after.aspect","com.annotation.after.beans"})
@EnableAspectJAutoProxy
public class GlobalJavaConfig {

}
