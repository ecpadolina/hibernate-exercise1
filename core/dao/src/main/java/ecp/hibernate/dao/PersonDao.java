package ecp.hibernate.dao;

import ecp.hibernate.model.Person;
import java.util.List;

public interface PersonDao{
	Boolean addPerson(Person person);
	Person getPerson(int personID);
	Boolean updatePerson(Person updatedPerson);
	Boolean deletePerson(Person person);
	List listPerson(int order, String column);
	List listPersonWithRoles(int roleId);
}