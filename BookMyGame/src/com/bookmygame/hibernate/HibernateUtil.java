package com.bookmygame.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try { 
        	System.out.println("Hibernate Version: " + org.hibernate.Version.getVersionString());
        	
        	//For Hibernate 4.x
//        	 Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
//      //  	 configuration.addAnnotatedClass(com.bookmygame.pojo.Customer.class);
//             StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//             serviceRegistryBuilder.applySettings(configuration.getProperties());
//             ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
//    			return configuration.buildSessionFactory(serviceRegistry);
        	
        	//For Hibernate 5.x
        	 StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
             Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
             return metadata.getSessionFactoryBuilder().build();
            
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
