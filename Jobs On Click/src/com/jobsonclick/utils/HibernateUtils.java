package com.jobsonclick.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.jobsonclick.models.Application;
import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;
import com.jobsonclick.models.Jobs;
import com.jobsonclick.models.Message;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	private static Transaction transaction;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/jobsonclick?useSSL=false");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "root");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	  //  settings.put(Environment.HBM2DDL_AUTO, "create-drop");
	    settings.put(Environment.HBM2DDL_AUTO, "update");
	    //settings.put(Environment.HBM2DDL_LOAD_SCRIPT_SOURCE, "");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(Company.class);
	    configuration.addAnnotatedClass(Candidate.class);
	    configuration.addAnnotatedClass(Message.class);
	    configuration.addAnnotatedClass(Jobs.class);
	    configuration.addAnnotatedClass(Application.class);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	 
	 public static Transaction getTransaction(Session session) {
		 // Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		 if(transaction == null) {
			 transaction= session.beginTransaction();
		 }
		 
		 return transaction;
	 }
	 
}
