package com.hibernate.dao.commands;

import com.hibernate.model.Role;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import com.hibernate.dao.Command;
import java.util.List;

public class ListRoles implements Command{
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		List list = session.createCriteria(Role.class).addOrder(Order.asc("role_id")).list();
		return list;
	}
}