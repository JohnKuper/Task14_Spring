package com.johnkuper.epam.mydb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Repository
@Autowired
public @interface DB {

	DBType value();

}
