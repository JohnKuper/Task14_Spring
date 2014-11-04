package com.johnkuper.epam.validation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainValidation {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfig.class);
		Driver driver = new Driver(15, "Misha", false);
		DriverService service = new DriverService(driver);
		Validator validator = context.getBean(Validator.class);
		validator.validate(driver);
		validator.validate(service);
	}

}
