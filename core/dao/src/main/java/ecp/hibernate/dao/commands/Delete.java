package ecp.hibernate.dao.commands;

import ecp.hibernate.model.Person;
import ecp.hibernate.dao.Command;
import org.hibernate.Session;

public class Delete<T> implements Command{
	private Session session;
	private T t;

	public Delete(T t){
		this.t = t;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		session.delete(t);
		return new Boolean(true);
	}
}