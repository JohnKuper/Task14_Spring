package com.johnkuper.epam.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitializationCheckerBeanPostProcessor implements
		BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object o, String arg1)
			throws BeansException {
		return o;
	}

	@Override
	public Object postProcessBeforeInitialization(Object o, String arg1)
			throws BeansException {
		String message = String.format(
				"Initialization of class = %s was successfully completed!", o
						.getClass().getSimpleName());
		System.out.println(message);
		return o;
	}

}
