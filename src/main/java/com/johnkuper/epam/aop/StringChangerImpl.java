package com.johnkuper.epam.aop;

import org.springframework.stereotype.Component;

@Component
public class StringChangerImpl implements StringChanger {

	@Override
	public String reverse(String source) {
		String retVal = new StringBuilder(source).reverse().toString();
		return retVal;
	}

	@Override
	public String printHello() {
		return "Hello!";
	}

}
