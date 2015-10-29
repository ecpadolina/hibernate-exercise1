package ecp.hibernate.service;

import ecp.hibernate.dao.PersonDaoHibernateImpl;
import ecp.hibernate.model.Person;

import java.util.List;

public class PersonManagerHibernateImpl implements PersonManager{

  private PersonDaoHibernateImpl pdao;
  
  public PersonManagerHibernateImpl(){
    pdao = new PersonDaoHibernateImpl();
  }
  
  public void addPerson(Person person){
    pdao.addPerson(person);
    System.out.println("Person added!");
  }
  
  public void updatePerson(Person person){
    pdao.updatePerson(person);
    System.out.println("Person updated!");
  }
  
  public void deletePerson(int id){
    pdao.deletePerson(id);
    System.out.println("Person deleted!");
  }
  
  public Person getPerson(int id){
    return pdao.getPerson(id);
  }
  
  public List listPerson(int order, String column){
    return pdao.listPerson(order,column);
  }
}
