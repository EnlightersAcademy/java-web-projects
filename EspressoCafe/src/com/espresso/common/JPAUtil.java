package com.espresso.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("espresso_cafe");

	public static EntityManagerFactory getEMF() {
		return emf;
	}
}




