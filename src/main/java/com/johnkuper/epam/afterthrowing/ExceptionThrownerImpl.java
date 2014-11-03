package com.johnkuper.epam.afterthrowing;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("requestHandlerImpl")
public class ExceptionThrownerImpl implements ExceptionThrowner {

	@Override
	public void throwDBAException(String message)
			throws DatabaseRuntimeException {

		throw new DatabaseRuntimeException(message);
	}

}
