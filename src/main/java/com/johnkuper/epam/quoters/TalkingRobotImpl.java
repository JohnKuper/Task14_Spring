package com.johnkuper.epam.quoters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.johnkuper.epam.annotation.Benchmark;
import com.johnkuper.epam.annotation.Transaction;

@Transaction
@Component
public class TalkingRobotImpl implements TalkingRobot {

	@Autowired
	private List<Quoter> quoters;

	@Override
	@Benchmark
	public void talk() {

		quoters.forEach(n -> n.sayQuote());

	}
}
