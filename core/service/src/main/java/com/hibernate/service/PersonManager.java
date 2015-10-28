package com.hibernate.service;

import com.hibernate.model.Person;
import java.util.List;

interface PersonManager{
	void addPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(int personId);
	Person getPerson(int personId);
	List listPerson(int order, String column);
}