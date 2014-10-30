package com.johnkuper.colors;

import java.awt.Color;
import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactory implements FactoryBean<Color> {

	@Override
	public Color getObject() throws Exception {
		Random random = new Random();
		return new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
