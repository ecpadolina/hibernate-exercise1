package ecp.hibernate.service;

import ecp.hibernate.dao.PersonDaoHibernateImpl;
import ecp.hibernate.dao.PersonDao;
import ecp.hibernate.model.Person;

import java.util.List;

public class PersonManagerHibernateImpl implements PersonManager{

  private PersonDao pdao;
  
  public PersonManagerHibernateImpl(){
    pdao = new PersonDaoHibernateImpl();
  }
  
  public void addPerson(Person person){
    if(pdao.addPerson(person))
      System.out.println("Person added!");
    else
      System.out.println("Person wasn't added!");
  }
  
  public void updatePerson(Person person){
    if(pdao.updatePerson(person))
      System.out.println("Person updated!");
    else
      System.out.println("Person wasn't updated!");
  }
  
  public void deletePerson(Person person){
    if((pdao.deletePerson(person)).booleanValue())
      System.out.println("Person deleted!");
    else
      System.out.println("Person wasn't deleted");
  }
  
  public Person getPerson(int id){
    return pdao.getPerson(id);
  }
  
  public List listPerson(int order, String column){
    return pdao.listPerson(order,column);
  }
}