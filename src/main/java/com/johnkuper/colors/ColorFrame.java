package com.johnkuper.colors;

import java.awt.Color;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColorFrame extends JFrame {
	
	@Autowired
	private Color color;
	
	private final static long serialVersionUID = 3462346356345L;

	public void setColor(Color color) {
		this.color = color;
	}

	@PostConstruct
	public void init() {
		setSize(400, 400);
		getContentPane().setBackground(color);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
