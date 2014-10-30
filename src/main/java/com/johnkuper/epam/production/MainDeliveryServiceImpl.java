package com.johnkuper.epam.production;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainDeliveryServiceImpl implements MainDeliveryService {

	@Autowired
	private Map<String, DeliveryService> map;

	@Override
	public void deliver(int deliveryType) {
		map.get(Integer.toString(deliveryType)).deliverDocument();
	}

}
