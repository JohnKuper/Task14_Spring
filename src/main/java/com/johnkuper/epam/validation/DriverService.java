package com.johnkuper.epam.validation;

import javax.validation.Valid;

public class DriverService {

	@Valid
	private Driver driver;

	public DriverService(Driver driver) {
		this.driver = driver;
	}

}
