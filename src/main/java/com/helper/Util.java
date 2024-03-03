package com.helper;

import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Util {

	public static int getNoteMaxId() {
		SessionFactory sessionFactory = FactoryProvider.getFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int maxId = 0;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("select max(id) from Note");

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

	public static int getNotebookMaxId() {
		SessionFactory sessionFactory = FactoryProvider.getFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int maxId = 0;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("select max(id) from Notebook");

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

	public static int getLabelMaxId() {
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

	public static int getCoverMaxId() {
		SessionFactory sessionFactory = FactoryProvider.getFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int maxId = 0;

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("select max(id) from Cover");

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

	public static int convertStringToInt(String str) {
		return Integer.parseInt(str);
	}

	public static String getId() {
		// Generate a random UUID
		UUID uuid = UUID.randomUUID();

		// Convert UUID to string
		String id = uuid.toString();

		// Print the generated ID
		System.out.println("Generated ID: " + id);
//		return Integer.parseInt(id);
		return id;
	}
}
