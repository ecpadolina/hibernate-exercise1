package ecp.hibernate.dao.commands;

import ecp.hibernate.model.Person;
import ecp.hibernate.dao.Command;
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