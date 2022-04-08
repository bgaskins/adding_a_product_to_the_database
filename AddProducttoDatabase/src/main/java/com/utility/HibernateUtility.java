package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Product;



public class HibernateUtility {

	public static SessionFactory buildSessionFactory() {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();

		return sessionFactory;
	}
	
}
