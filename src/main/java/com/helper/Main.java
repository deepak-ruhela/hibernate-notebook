package com.helper;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	/**
	 * mail_mevinod@yahoo.co.in
	 */
	public static void main(String[] args) {

		System.out.println("Max ID: " + Util.getLabelMaxId());

	}

	public static int getNoteMaxId() {
		SessionFactory sessionFactory = FactoryProvider.getFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int maxId = 0;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("select max(id) from Label");
			
			Number result = (Number) query.uniqueResult();
			if (result != null) {
		        maxId = result.intValue();
		    }
//			maxId = (int) query.uniqueResult();
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return maxId + 1;

	}
}
