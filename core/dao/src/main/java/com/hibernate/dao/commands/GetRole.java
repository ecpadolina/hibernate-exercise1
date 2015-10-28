package com.hibernate.dao.commands;

import com.hibernate.model.Role;
import org.hibernate.Session;
import com.hibernate.dao.Command;

public class GetRole implements Command{
	private Session session;
	private Integer id;

	public GetRole(Integer id){
		this.id = id;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		Role role = (Role)session.get(Role.class, id);
		return role;
	}
}