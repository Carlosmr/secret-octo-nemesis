package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;

import java.util.Set;

public class ValorarIncidenciaImpl implements ValorarIncidencia {

	private RepositorioIncidenciasImpl ri;

	public ValorarIncidenciaImpl() {
		ri = new RepositorioIncidenciasImpl();
	}

	public Set<Incidencia> listarIncidenciaPorDni(String dni) {
		return ri.buscarIncidenciasPorDni(dni);
	}

	public void registrarValoracion(Integer id, Integer val) {
		ri.getIncidencia(id).getRespuesta().setValoracion(val);
	}

}
