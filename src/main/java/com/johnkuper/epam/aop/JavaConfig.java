package com.johnkuper.epam.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.johnkuper.epam.aop" })
@EnableAspectJAutoProxy
public class JavaConfig {

}
