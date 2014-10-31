package com.johnkuper.colors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ColorMain {

	public static void main(String[] args) throws InterruptedException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				Config.class);
		for (int i = 0; i < 25; i++) {
			Thread.sleep(40);
			ColoredFrame frame = context.getBean(ColoredFrame.class);
			frame.showOnRandomPlace();
		}
	}

}
