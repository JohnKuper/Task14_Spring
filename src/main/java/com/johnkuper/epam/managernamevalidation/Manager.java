package com.johnkuper.epam.managernamevalidation;

public class Manager {

	@ManagerName(message = "it's not a manager name")
	private String name;

	public Manager(String name) {
		this.name = name;
	}

}
