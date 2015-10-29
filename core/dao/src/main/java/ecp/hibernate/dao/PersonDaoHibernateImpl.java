package ecp.hibernate.dao;

import ecp.hibernate.dao.commands.GetPerson;
import ecp.hibernate.dao.commands.AddPerson;
import ecp.hibernate.dao.commands.DeletePerson;
import ecp.hibernate.dao.commands.UpdatePerson;
import ecp.hibernate.dao.commands.ListPerson;
import ecp.hibernate.model.Person;
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