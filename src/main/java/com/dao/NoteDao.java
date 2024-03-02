package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.entities.Note;
import com.helper.FactoryProvider;

public class NoteDao {
//	private final EntityManager entityManager = EntityManagerProvider.getEntityManager();
	private final Session session = FactoryProvider.getFactory().openSession();

	public Note getNoteById(int id) {

//		Session s = FactoryProvider.getFactory().openSession();
		Note note = (Note) session.get(Note.class, id);
		return note;

	}

	public List<Note> getAllNotes() {
//		Session session = FactoryProvider.getFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Note> criteriaQuery = criteriaBuilder.createQuery(Note.class);
		Root<Note> root = criteriaQuery.from(Note.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

}
