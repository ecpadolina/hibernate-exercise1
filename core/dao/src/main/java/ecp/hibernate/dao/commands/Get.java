package ecp.hibernate.dao.commands;

import ecp.hibernate.model.Role;
import org.hibernate.Session;
import ecp.hibernate.dao.Command;

public class Get<T> implements Command{
	private Session session;
	private Integer id;
	private Class<T> entityClass;

	public Get(Integer id, Class<T> entityClass){
		this.id = id;
		this.entityClass = entityClass;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		return session.get(entityClass, id);
	}
}