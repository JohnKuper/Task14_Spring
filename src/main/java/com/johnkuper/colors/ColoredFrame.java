package com.johnkuper.colors;

import java.awt.Color;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Component;

@Component
public abstract class ColoredFrame extends JFrame {

	private final static long serialVersionUID = 3462346356345L;

	@PostConstruct
	public void init() {
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void showOnRandomPlace() {
		Random random = new Random();
		setLocation(random.nextInt(800), random.nextInt(500));
		getContentPane().setBackground(getColor());
		this.validate();
		this.repaint();
	}

	public abstract Color getColor();
}
