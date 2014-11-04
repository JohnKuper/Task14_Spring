package com.johnkuper.epam.validation;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Driver {

	@Min(value = 18, message = "Driver is too young")
	private int age;
	@NotNull(message = "Name may not be null")
	private String name;
	@AssertFalse (message = "Alcoholic must be false")
	private boolean alcoholic;

	public Driver(int age, String name, boolean alcoholic) {
		this.age = age;
		this.name = name;
		this.alcoholic = alcoholic;
	}

}
