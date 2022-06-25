package com.vti.repository;

import com.vti.entity.Article2;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleRepository2 {

	private HibernateUtils hibernateUtils;

	public ArticleRepository2() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Article2> getAllArticle() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Article2> query = session.createQuery("FROM Article2 ");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createArticle2(Article2 article) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(article);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
