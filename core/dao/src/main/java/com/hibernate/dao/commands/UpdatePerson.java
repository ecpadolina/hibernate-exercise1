package com.hibernate.dao.commands;

import com.hibernate.model.Person;
import com.hibernate.dao.Command;
import org.hibernate.Session;

public class UpdatePerson implements Command{
	private Session session;
	private Person updatedPerson;

	public UpdatePerson(Person updatedPerson){
		this.updatedPerson = updatedPerson;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		session.update(updatedPerson);
		return null;
	}
}