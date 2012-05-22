package isw2.servicio.tecnico;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class BajaTecnicoImpl implements BajaTecnico {

	private RepositorioTecnicos rt;
	private Tecnico t;

	public BajaTecnicoImpl() {

		EntityManager em = SingleEntityManager.getEntityManager();
		rt = new RepositorioTecnicosImpl(em);

	}

	public Set<Tecnico> listarTecnicosActivos() {

		return rt.getTecnicosActivos();
	}

	public Set<Tecnico> listarTecnicos() {

		return rt.getTecnicos();
	}

	public void darDeBajaTecnico(String user) {

		t = rt.getTecnico(user);
		t.setDadoDeBaja(true);

	}

}
