package com.vti.repository;

import org.hibernate.Session;

import com.vti.entity.Article1;
import com.vti.utils.HibernateUtils;

public class ArticleRepository {

	private HibernateUtils hibernateUtils;

	public ArticleRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public void createArticle1(Article1 article1) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(article1);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
