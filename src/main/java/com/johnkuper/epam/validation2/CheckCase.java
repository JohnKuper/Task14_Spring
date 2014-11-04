package com.johnkuper.epam.validation2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CheckCaseValidations.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

	CaseType value();

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
