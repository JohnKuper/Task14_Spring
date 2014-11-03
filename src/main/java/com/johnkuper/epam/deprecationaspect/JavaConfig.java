package com.johnkuper.epam.deprecationaspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.johnkuper.epam.deprecationaspect" })
@EnableAspectJAutoProxy
public class JavaConfig {

}
