package com.hibernate.dao.commands;

import com.hibernate.model.Role;
import org.hibernate.Session;
import com.hibernate.dao.Command;

public class UpdateRole implements Command{
	private Session session;
	private Role role;

	public UpdateRole(Role role){
		this.role = role;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		session.update(role);
		return null;
	}
}