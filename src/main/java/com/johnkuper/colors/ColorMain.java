package com.johnkuper.colors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ColorMain {

	public static void main(String[] args) {

		new AnnotationConfigApplicationContext(Config.class);
	}

}
