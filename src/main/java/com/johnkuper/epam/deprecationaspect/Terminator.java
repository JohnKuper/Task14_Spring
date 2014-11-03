package com.johnkuper.epam.deprecationaspect;

import com.johnkuper.epam.annotation.MyDeprecated;

@MyDeprecated(newClass = T1000.class)
public class Terminator implements SaraKonnorMurderer {

	public void killSaraKonnor() {
		System.out
				.println("I'm angry terminator and I will kill Sara very soon....");
	}
}
