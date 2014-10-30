package com.johnkuper.epam.mydb;

@DB(DBType.ORACLE)
public class OracleDao implements Dao {

	@Override
	public void crud() {

		System.out.println("I'm oracle dao...");

	}

}
