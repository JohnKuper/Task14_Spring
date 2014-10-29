package com.johnkuper.epam;

import java.util.List;

import com.johnkuper.epam.annotation.Benchmark;


public class TalkingRobotImpl implements TalkingRobot {

	private List<Quoter> quoters;

	public void setQuoters(List<Quoter> quoters) {
		this.quoters = quoters;
	}

	@Benchmark
	@Override
	public void talk() {

		quoters.forEach(n -> n.sayQuote());

	}

}
