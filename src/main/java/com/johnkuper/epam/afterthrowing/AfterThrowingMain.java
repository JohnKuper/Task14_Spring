package com.johnkuper.epam.afterthrowing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterThrowingMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfig.class);
		context.getBean(RequestHandler.class).findUserByID(0);
	}

}
