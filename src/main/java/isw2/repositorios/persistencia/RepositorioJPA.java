package isw2.repositorios.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class RepositorioJPA {
	private static EntityManagerFactory emf;

	public EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("isw2.acme");
		}
		return emf.createEntityManager();
	}
}