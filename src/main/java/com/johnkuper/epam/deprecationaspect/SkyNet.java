package com.johnkuper.epam.deprecationaspect;

import org.springframework.stereotype.Component;

@Component
public class SkyNet implements TerminatorFactory {

	@Override
	public Terminator createTerminator() {
		return new Terminator();
	}

}
