package com.johnkuper.epam.dependson;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"com.johnkuper.epam.dependson");
	}

}
