package com.johnkuper.epam;


public class ShakespeareQuoter implements Quoter {

	String message;

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void sayQuote() {
		System.out.println(message);
	}

}
