package com.johnkuper.epam;

import java.util.List;

public class TerminatorQuoter implements Quoter {

	private List<String> messages;

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void sayQuote() {
		messages.forEach(m -> System.out.println(m));

	}
}
