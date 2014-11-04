package com.johnkuper.epam.managernamevalidation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Size(min = 5, max = 15, message = "name must be between 5 and 15 letters")
@CheckCase(value = CaseType.UPPER_CASE, message = "manager name must be upper cased")
public @interface ManagerName {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
