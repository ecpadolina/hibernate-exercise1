package com.hibernate.dao;

import com.hibernate.dao.commands.GetPerson;
import com.hibernate.dao.commands.AddPerson;
import com.hibernate.dao.commands.DeletePerson;
import com.hibernate.dao.commands.UpdatePerson;
import com.hibernate.dao.commands.ListPerson;
import com.hibernate.model.Person;
import java.util.List;

public class PersonDaoHibernateImpl implements PersonDao{
	
	public void addPerson(Person person) {
        HibernateUtil.perform(new AddPerson(person), Integer.class);
    }

    public Person getPerson(int personID) {
        return HibernateUtil.perform(new GetPerson(personID), Person.class);
    }

    public void updatePerson(Person updatedPerson) {
        HibernateUtil.perform(new UpdatePerson(updatedPerson), Person.class);
    }

    public void deletePerson(int personID) {
        HibernateUtil.perform(new DeletePerson(personID), Person.class);
    }

    public List listPerson(int order, String column) {
        return HibernateUtil.perform(new ListPerson(order, column), List.class);
	}
}