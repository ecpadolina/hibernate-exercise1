package com.hibernate.dao.commands;

import com.hibernate.model.Person;
import com.hibernate.dao.Command;
import org.hibernate.Session;

public class DeletePerson implements Command{
	private Integer id;
	private Session session;

	public DeletePerson(Integer id){
		this.id = id;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		Person person = (Person)session.get(Person.class, id);
		session.delete(person);
		return null;
	}
}