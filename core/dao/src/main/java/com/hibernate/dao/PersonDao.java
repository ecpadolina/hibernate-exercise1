package com.hibernate.dao;

import com.hibernate.model.Person;
import java.util.List;

interface PersonDao{
	void addPerson(Person person);
	Person getPerson(int personID);
	void updatePerson(Person updatedPerson);
	void deletePerson(int personID);
	List listPerson(int order, String column);
}