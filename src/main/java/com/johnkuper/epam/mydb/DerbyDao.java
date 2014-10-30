package com.johnkuper.epam.mydb;


@DB(DBType.DERBY)
public class DerbyDao implements Dao {

	@Override
	public void crud() {
		System.out.println("I'm derby dao...");
	}

}
