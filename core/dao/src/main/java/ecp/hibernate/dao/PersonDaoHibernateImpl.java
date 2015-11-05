package ecp.hibernate.dao;

import ecp.hibernate.dao.commands.Get;
import ecp.hibernate.dao.commands.Add;
import ecp.hibernate.dao.commands.Delete;
import ecp.hibernate.dao.commands.Update;
import ecp.hibernate.dao.commands.GetList;
import ecp.hibernate.dao.commands.CustomQuery;
import ecp.hibernate.model.Person;
import java.util.List;

public class PersonDaoHibernateImpl implements PersonDao{
	
	public Boolean addPerson(Person person) {
        return HibernateUtil.perform(new Add(person), Boolean.class);
    }

    public Person getPerson(int personID) {
        return HibernateUtil.perform(new Get(personID, Person.class), Person.class);
    }

    public Boolean updatePerson(Person updatedPerson) {
        return HibernateUtil.perform(new Update(updatedPerson), Boolean.class);
    }

    public Boolean deletePerson(Person person) {
        return HibernateUtil.perform(new Delete(person), Boolean.class);
    }

    public List listPerson(int order, String column) {
        return HibernateUtil.perform(new GetList(order, column, Person.class), List.class);
	}
    public List listPersonWithRoles(int roleId){
        return HibernateUtil.perform(new CustomQuery(roleId), List.class);
    }
}