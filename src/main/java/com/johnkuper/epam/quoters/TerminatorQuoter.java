package com.johnkuper.epam.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.johnkuper.epam.annotation.MyDeprecated;

@Component
@MyDeprecated(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {

	@Value("${terminatorQuotes}")
	private String[] messages;

	public void sayQuote() {
		for (String message : messages) {
			System.out.println(message);
		}

	}
}
