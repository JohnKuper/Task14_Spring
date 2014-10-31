package com.johnkuper.colors;

import java.awt.Color;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = { "com.johnkuper.colors" })
public class Config {

	@Bean
	@Scope("prototype")
	public Color randomColor() {
		Random random = new Random();
		return new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
	}

	@Bean
	public ColoredFrame coloredFrame() {
		ColoredFrame frame = new ColoredFrame() {

			private static final long serialVersionUID = 1132202059061192475L;

			@Override
			public Color getColor() {
				return randomColor();
			}
		};

		return frame;

	}
}
