package isw2.repositorios.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SingleEntityManager {
	private static EntityManager instance;

	private SingleEntityManager() {

	}

	public static EntityManager getEntityManager() {
		if (instance == null)
			instance = Persistence.createEntityManagerFactory("isw2.acme")
					.createEntityManager();
		return instance;
	}

}
