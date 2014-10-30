package com.johnkuper.epam.production;

import org.springframework.stereotype.Service;


@Service("2")
public class ByeByeClientService implements DeliveryService {

	@Override
	public void deliverDocument() {
		System.out.println("Bye bye client!");

	}

}
