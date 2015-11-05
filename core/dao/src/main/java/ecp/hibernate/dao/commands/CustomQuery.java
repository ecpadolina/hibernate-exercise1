package ecp.hibernate.dao.commands;

import ecp.hibernate.dao.Command;
import org.hibernate.Session;
import java.util.List;

public class CustomQuery implements Command{
	private Session session;
	private int parameter;

	public CustomQuery(int parameter){
		this.parameter = parameter;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		List list = session.createQuery("select person.id, person.name from Person person INNER JOIN person.roles as proles where proles.role_id = :role_id").
					setParameter("role_id", parameter).list();
		return list;
	}
}