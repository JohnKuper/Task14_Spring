package com.johnkuper.epam.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShakespeareQuoter implements Quoter {

	@Value("${shakespeareQuote}")
	String message;

	@Override
	public void sayQuote() {
		System.out.println(message);
	}

}
