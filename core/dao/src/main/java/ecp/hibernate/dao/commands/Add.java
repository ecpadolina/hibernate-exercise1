package ecp.hibernate.dao.commands;

import ecp.hibernate.model.Person;
import ecp.hibernate.dao.Command;
import org.hibernate.Session;

public class Add<T> implements Command{
	private T t;
	private Session session;

	public Add(T t){
		this.t = t;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		session.save(t);
		return new Boolean(true);
	}
}