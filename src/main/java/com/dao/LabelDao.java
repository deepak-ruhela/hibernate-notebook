package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.entities.Label;
import com.helper.FactoryProvider;

public class LabelDao {

	private final Session session = FactoryProvider.getFactory().openSession();

	public Label getLabelById(int id) {
//		Session s = FactoryProvider.getFactory().openSession();
		Label notebook = (Label) session.get(Label.class, id);
		return notebook;

	}

//	public Label edtLabel(Label label) {
//		Session s = FactoryProvider.getFactory().openSession();
//		Label notebook = (Label) s.get(Label.class, id);
//		return notebook;
//
//	}

	public List<Label> getAllLabels() {
//		Session session = FactoryProvider.getFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Label> criteriaQuery = criteriaBuilder.createQuery(Label.class);
		Root<Label> root = criteriaQuery.from(Label.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

}
