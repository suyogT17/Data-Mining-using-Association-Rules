package main.java.com.datamining.dao;

import main.java.com.datamining.hibernateutil.HibernateManager;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractDAO {
	
	public SessionFactory getSessionFactory()
	{
		return HibernateManager.getSessionFactory();
	}

}
