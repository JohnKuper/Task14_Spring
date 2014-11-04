package com.johnkuper.epam.validation2;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Validation2Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"com.johnkuper.epam.validation2");

		Validator validator = context.getBean(Validator.class);
		Set<ConstraintViolation<Person>> violations = validator
				.validate(new Person("VASYA"));
		for (ConstraintViolation<Person> violation : violations) {
			System.out.println(violation.getMessage());
		}

	}

}
