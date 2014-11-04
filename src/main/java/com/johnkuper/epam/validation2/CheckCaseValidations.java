package com.johnkuper.epam.validation2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidations implements
		ConstraintValidator<CheckCase, String> {

	private CaseType caseType;

	@Override
	public void initialize(CheckCase constraintAnnotation) {
		caseType = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext context) {
		if (caseType == CaseType.UPPER_CASE) {
			return s.equals(s.toUpperCase());
		} else if (caseType == CaseType.LOWER_CASE) {
			return s.equals(s.toLowerCase());
		}

		return false;

	}

}
