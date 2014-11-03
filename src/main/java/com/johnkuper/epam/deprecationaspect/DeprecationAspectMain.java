package com.johnkuper.epam.deprecationaspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeprecationAspectMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfig.class);
		Terminator t = context.getBean(TerminatorFactory.class)
				.createTerminator();

	}

}
