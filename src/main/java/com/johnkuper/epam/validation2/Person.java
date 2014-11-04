package com.johnkuper.epam.validation2;

public class Person {

	@CheckCase(value = CaseType.UPPER_CASE, message = "manager must have upperCase name")
	private String name;

	public Person(String name) {
		this.name = name;
	}

}
