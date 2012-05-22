package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class BuscarCatalogoIncidenciaImpl implements BuscarCatalogoIncidencia {

	private RepositorioIncidenciasImpl ri;

	public BuscarCatalogoIncidenciaImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
	}

	public Set<Incidencia> busquedaParaIncidencia(String busqueda) {
		return ri.buscarIncidencia(busqueda);
	}

}
