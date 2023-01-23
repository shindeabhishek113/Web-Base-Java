package com.util;

import org.hibernate.cfg.Configuration;

import org.hibernate.*;

public class HibernateUtils {
	
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
		
	}

	public static SessionFactory getFactory() {
		return factory;
	}
	
	

}
