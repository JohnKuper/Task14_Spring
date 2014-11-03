package com.johnkuper.epam.afterthrowing;

public interface ExceptionThrowner {

	void throwDBAException(String message) throws DatabaseRuntimeException;

}
