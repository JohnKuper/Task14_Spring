package com.johnkuper.epam.afterthrowing;

public class DatabaseRuntimeException extends RuntimeException {

	public DatabaseRuntimeException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -5378554811374536985L;
}
