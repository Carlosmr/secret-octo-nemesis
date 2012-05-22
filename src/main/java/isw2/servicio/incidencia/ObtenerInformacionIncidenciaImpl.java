package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class ObtenerInformacionIncidenciaImpl implements
		ObtenerInformacionIncidencia {

	private RepositorioIncidenciasImpl ri;

	public ObtenerInformacionIncidenciaImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
	}

	public Set<Incidencia> listarIncidencias() {
		return ri.getIncidencias();
	}

	public Incidencia seleccionarIncidencia(Integer id) {
		return ri.getIncidencia(id);
	}

}
