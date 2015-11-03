package ecp.hibernate.service;

import ecp.hibernate.model.Person;
import java.util.List;

public interface PersonManager{
	void addPerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person person);
	Person getPerson(int personId);
	List listPerson(int order, String column);
}