	package com.hibernate.dao.commands;

import com.hibernate.model.Person;
import com.hibernate.dao.Command;
import org.hibernate.Session;

public class AddPerson implements Command{
	private Person person;
	private Session session;

	public AddPerson(Person person){
		this.person = person;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		return (Integer) session.save(person);
	}
}