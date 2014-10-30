package com.johnkuper.epam;

import java.util.List;

import com.johnkuper.epam.annotation.MyDeprecated;

@MyDeprecated(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {

	private List<String> messages;

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void sayQuote() {
		messages.forEach(m -> System.out.println(m));

	}
}
