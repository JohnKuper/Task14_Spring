package com.johnkuper.epam.managernamevalidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManagerValidationMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"com.johnkuper.epam.managernamevalidation");

		Validator validator = context.getBean(Validator.class);
		Set<ConstraintViolation<Manager>> violations = validator
				.validate(new Manager("VASYAa"));
		for (ConstraintViolation<Manager> violation : violations) {
			System.out.println(violation.getMessage());
		}

	}

}
