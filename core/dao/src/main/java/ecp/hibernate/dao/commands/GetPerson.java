package ecp.hibernate.dao.commands;

import ecp.hibernate.model.Person; 
import ecp.hibernate.dao.Command;
import org.hibernate.Session;

public class GetPerson implements Command{
	private Integer id;
	private Session session;

	public GetPerson(Integer id){
		this.id = id;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		Person person = (Person) session.get(Person.class, id);
		return person;
	}
}