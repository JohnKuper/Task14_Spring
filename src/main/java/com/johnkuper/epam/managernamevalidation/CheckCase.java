package com.johnkuper.epam.managernamevalidation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

	CaseType value();

	String message();

}
