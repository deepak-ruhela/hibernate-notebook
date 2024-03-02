package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Note;
import com.entities.Notebook;
import com.helper.FactoryProvider;

public class NotebookDao {
	private final Session session = FactoryProvider.getFactory().openSession();

//	private final SessionFactory sessionFactory;

//	public NotebookDao(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	public NotebookDao() {

	}

	public List<Note> getAllNotesForNotebook(int notebookId) {
		List<Note> notes = null;
//		Session session = FactoryProvider.getFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			String hql = "FROM Note WHERE notebook.id = :notebookId";
			Query<Note> query = session.createQuery(hql, Note.class);
			query.setParameter("notebookId", notebookId);
			notes = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return notes;
	}

	public Notebook getNotebookById(int id) {
		Session s = FactoryProvider.getFactory().openSession();
		Notebook notebook = (Notebook) s.get(Notebook.class, id);
		return notebook;

	}

	public List<Notebook> getAllNotebooks() {
//		Session session = FactoryProvider.getFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Notebook> criteriaQuery = criteriaBuilder.createQuery(Notebook.class);
		Root<Notebook> root = criteriaQuery.from(Notebook.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

}
