package com.johnkuper.epam.mydb;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements DbService {

	@DB(DBType.DERBY)
	private Dao dao;

	@Override
	@PostConstruct
	public void doWork() {
		System.out.println("I'm service, I use: ");
		dao.crud();
	}

}
