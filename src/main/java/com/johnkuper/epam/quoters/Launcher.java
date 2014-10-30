package com.johnkuper.epam.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		TalkingRobot robot = context.getBean(TalkingRobot.class);
		robot.talk();

	}

}
