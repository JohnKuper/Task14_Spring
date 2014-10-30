package com.johnkuper.epam.production;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductionMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"com.johnkuper.epam.production");
		MainDeliveryService deliveryService = context
				.getBean(MainDeliveryService.class);
		deliveryService.deliver(2);

	}

}
