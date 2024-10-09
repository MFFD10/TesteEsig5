package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Creator {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	private Creator() {
	}

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("testUP");
			em = emf.createEntityManager();
		}
		return em;
	}

	public static void closeEntityManagerFactory() {
		if (emf != null && emf.isOpen()) {
			em.close();
			emf.close();
		}
	}
}