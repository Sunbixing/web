package com.example.service;

import java.util.List;

import com.example.domin.Good;
import com.example.domin.Person;

public interface OraclePerson {

	void save(String name, String pwd) throws Exception;

	List<Person> find() throws Exception;

	List<Good> findGood() throws Exception;

	void delete(String id) throws Exception;

	void update(String id, String title, String content, String comment) throws Exception;

}