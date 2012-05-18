package isw2.repositorios.persistencia;

import javax.persistence.EntityManager;

public abstract class RepositorioJPA {
	private EntityManager entityManager;
	
	public RepositorioJPA(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}