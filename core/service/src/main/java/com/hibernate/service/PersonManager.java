package com.hibernate.service;

import com.hibernate.dao.PersonDao;
import com.hibernate.model.Person;
import com.hibernate.model.Role;

import java.util.List;

public class PersonManager{

  private PersonDao pdao;
  
  public PersonManager(){
    pdao = new PersonDao();
  }
  
  public void addPerson(Person person){
    if(pdao.addPerson(person))
      System.out.println("Person added!");
    else
      System.out.println("Something went wrong. Person wasn't updated.");
  }
  
  public void updatePerson(Person person){
    if(pdao.updatePerson(person))
      System.out.println("Person updated!");
    else
      System.out.println("Something went wrong. Person wasn't updated.");
  }
  
  public void deletePerson(int id){
    if(pdao.deletePerson(id))
      System.out.println("Person deleted!");
    else
      System.out.println("Something went wrong. Person wasn't deleted.");    
  }
  
  public Person getPerson(int id){
    return pdao.getPerson(id);
  }
  
  public List listPerson(int order, String column){
    return pdao.listPerson(order,column);
  }
  
  public List listRoles(){
    return pdao.listRoles();
  }
  
  public Role getRole(int id){
    return pdao.getRole(id);
  }

  public void updateRole(Role role){
    if(pdao.updateRole(role))
      System.out.println("Role Updated!");
    else
      System.out.println("Something went wrong. Role wasn't updated.");
  }
  
}
