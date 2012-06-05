package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;

import java.util.Set;

public class BuscarCatalogoIncidenciaImpl implements BuscarCatalogoIncidencia {

	private RepositorioIncidenciasImpl ri;

	public BuscarCatalogoIncidenciaImpl() {
		ri = new RepositorioIncidenciasImpl();
	}

	public Set<Incidencia> busquedaParaIncidencia(String busqueda) {
		return ri.buscarIncidencia(busqueda);
	}

}
