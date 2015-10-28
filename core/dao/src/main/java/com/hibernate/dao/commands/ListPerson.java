package com.hibernate.dao.commands;

import com.hibernate.model.Person;
import com.hibernate.dao.Command;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import java.util.List;

public class ListPerson implements Command{
	private Session session;
	private String column;
	private int order;

	public ListPerson(int order, String column){
		this.column = column;
		this.order = order;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Object execute(){
		List list = null;
		if(order == 1){
			list = session.createCriteria(Person.class).addOrder(Order.asc(column)).list();
		} else {
			list = session.createCriteria(Person.class).addOrder(Order.desc(column)).list();
		}
		return list;
	}
}