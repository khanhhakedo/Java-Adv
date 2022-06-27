package com.vti.utils;

import com.vti.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(UserOneToOne.class);
		configuration.addAnnotatedClass(UserManyToOne.class);
		configuration.addAnnotatedClass(UserManyToMany.class);
		configuration.addAnnotatedClass(UserAddress .class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Address .class);
		configuration.addAnnotatedClass(AddressOneToOne.class);
		configuration.addAnnotatedClass(AddressManyToOne.class);
		configuration.addAnnotatedClass(AddressManyToMany.class);

	}

	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
