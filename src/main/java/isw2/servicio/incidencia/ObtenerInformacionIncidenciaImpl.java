package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;

import java.util.Set;

public class ObtenerInformacionIncidenciaImpl implements
		ObtenerInformacionIncidencia {

	private RepositorioIncidenciasImpl ri;

	public ObtenerInformacionIncidenciaImpl() {
		ri = new RepositorioIncidenciasImpl();
	}

	public Set<Incidencia> listarIncidencias() {
		return ri.getIncidencias();
	}

	public Incidencia seleccionarIncidencia(Integer id) {
		return ri.getIncidencia(id);
	}

}
