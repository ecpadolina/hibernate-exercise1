package com.hibernate.dao;

import com.hibernate.model.*;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class PersonDao implements PersonDaoInterface{

  private static SessionFactory factory;
  
  public PersonDao(){
		try{
			factory = new Configuration().configure().buildSessionFactory(); 
		}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public List listPerson(int order, String column){
	  List list = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			if(order == 1)
  				list = session.createCriteria(Person.class).addOrder(Order.asc(column)).list();
  			else
  		  		list = session.createCriteria(Person.class).addOrder(Order.desc(column)).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public Person getPerson(int id){
		Person person = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			person = (Person)session.get(Person.class, id);
			tx.commit();
		} catch(HibernateException e){
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();		
		}finally {
			session.close();
		}
		return person;
	}
	
	public boolean addPerson(Person person){
	  Session session = factory.openSession();
	  Transaction tx = null;
	  try{
	    tx = session.beginTransaction();
	    session.save(person);
	    tx.commit();
	    return true;
	  } catch (HibernateException e){
	    if(tx != null)
	      tx.rollback();
	    e.printStackTrace();
	  } finally {
	    session.close();
	  }
	  return false;
	}
	
	public boolean updatePerson(Person updatedPerson){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(updatedPerson);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	public boolean deletePerson(int personID){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Person person = (Person)session.get(Person.class, personID);
			session.delete(person);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				System.out.println("Remove roles first before deleting a person.");
		} finally {
			session.close();
		}
		return false;
	}
	
	public List listRoles(){
		List list = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			list = session.createCriteria(Role.class).addOrder(Order.asc("role_id")).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public Role getRole(int roleId){
		Role role = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			role = (Role)session.get(Role.class, roleId);
			tx.commit();
		} catch(HibernateException e){
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();		
		}finally {
			session.close();
		}
		return role;
	}

	public boolean updateRole(Role role){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(role);
			tx.commit();
			return true;
		} catch(HibernateException e){
			if (tx!=null) tx.rollback();
				e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();		
		}finally {
			session.close();
		}
		return false;
	}
	
}
