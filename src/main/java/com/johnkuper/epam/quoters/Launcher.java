package com.johnkuper.epam.quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfig.class);
		context.getBean(TalkingRobot.class).talk();
	}

}
