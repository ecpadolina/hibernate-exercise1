package com.hibernate.dao;

import java.util.List;
import com.hibernate.model.Person;
import com.hibernate.model.Role;

public interface PersonDaoInterface{
	public List listPerson(int order, String column);
	public Person getPerson(int id);
	public boolean addPerson(Person person);
	public boolean updatePerson(Person person);
	public List listRoles();
	public Role getRole(int roleID);
	public boolean updateRole(Role role);
}