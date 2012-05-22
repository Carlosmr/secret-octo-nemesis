package isw2.servicio.tecnico;

import javax.persistence.EntityManager;

import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

public class AutentificarTecnicoImpl implements AutentificarTecnico {

	private RepositorioTecnicosImpl rp;

	public AutentificarTecnicoImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		rp = new RepositorioTecnicosImpl(em);
	}

	public void logIn(String user, String password) {
		rp.logIn(user, password);
	}

}
