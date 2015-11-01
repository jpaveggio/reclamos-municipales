package ar.edu.unrn.bdii.reclamos.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf;
	
	
	static{
		try {
			emf = Persistence.createEntityManagerFactory("reclamos");
		} catch(Throwable ex ) {
			System.err.println("Initial SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

}
