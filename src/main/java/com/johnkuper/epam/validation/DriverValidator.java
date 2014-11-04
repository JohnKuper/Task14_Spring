package com.johnkuper.epam.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class DriverValidator implements Validator {

	@Autowired
	public LocalValidatorFactoryBean validator;

	@Override
	public <T> void validate(T validateObject) {
		Set<ConstraintViolation<T>> vioSet = validator.validate(validateObject);
		for (ConstraintViolation<T> violation : vioSet) {
			System.out.println(violation.getMessage());
		}
	}

}
