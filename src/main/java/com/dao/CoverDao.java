package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.entities.Cover;
import com.helper.FactoryProvider;

public class CoverDao {
	private final Session session = FactoryProvider.getFactory().openSession();

	public Cover getCoverById(int id) {
//		Session s = FactoryProvider.getFactory().openSession();
		Cover cover = (Cover) session.get(Cover.class, id);
		return cover;

	}

	public List<Cover> getAllCovers() {
//		Session session = FactoryProvider.getFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Cover> criteriaQuery = criteriaBuilder.createQuery(Cover.class);
		Root<Cover> root = criteriaQuery.from(Cover.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

}
