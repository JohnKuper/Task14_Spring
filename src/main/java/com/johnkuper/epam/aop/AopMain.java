package com.johnkuper.epam.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfig.class);
		StringChanger changer = context.getBean(StringChanger.class);
		changer.reverse("JohnKuper");
		changer.printHello();

	}

}
