package com.johnkuper.epam.deprecationaspect;

import org.springframework.stereotype.Component;

@Component
public class T1000 extends Terminator {

	@Override
	@PostInitialized
	public void killSaraKonnor() {
		System.out.println("I'm T1000. I don't wanna hurt Sara!");
	}

}
