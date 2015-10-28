package com.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
	private static SessionFactory factory;
    public static void createSessionFactory(){
        try {
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Failed to create session factory object.");
            e.printStackTrace();
        }
    }
    public static void closeSessionFactory(){
        factory.close();
    }

    public static <T> T perform(Command command, Class<T> returnClass) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Object returnObject = null;

        try {
            command.setSession(session);
            returnObject = command.execute();
            transaction.commit();
		} catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Unable to perform transaction.");
            e.printStackTrace();
        } finally {
            session.close();
        }

        return returnClass.cast(returnObject);
    }
}