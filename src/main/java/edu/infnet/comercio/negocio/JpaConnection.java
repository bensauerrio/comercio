package edu.infnet.comercio.negocio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnection {
	
	private static EntityManagerFactory emf; 
	
	public JpaConnection() {}
	

	public static EntityManagerFactory getEmf() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("comercio");
		}
		return emf;
	}
}
