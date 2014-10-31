package com.johnkuper.epam.quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = { "com.johnkuper.epam.quoters",
		"com.johnkuper.epam.annotaion", "com.johnkuper.epam.beanpostprocessors" })
@PropertySource("classpath:quotes.properties")
@EnableAspectJAutoProxy
public class JavaConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
