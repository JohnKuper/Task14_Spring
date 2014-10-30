package com.johnkuper.epam;

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

	public void setQuoters(List<Quoter> quoters) {
		this.quoters = quoters;
	}

	@Override
	@Benchmark
	public void talk() {

		quoters.forEach(n -> n.sayQuote());

	}
}
