package com.johnkuper.colors;

import java.awt.Color;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.johnkuper.colors" })
public class Config {

	@Bean
	public Color randomColor() {
		Random random = new Random();
		return new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
	}

}
