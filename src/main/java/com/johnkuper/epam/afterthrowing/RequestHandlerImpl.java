package com.johnkuper.epam.afterthrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestHandlerImpl implements RequestHandler {

	@Autowired
	ExceptionThrowner throwner;

	@Override
	public void findUserByID(int x) {

		if (x < 1) {
			throwner.throwDBAException("ID can't be less then 1. Please enter the correct value");
		}
	}

}
