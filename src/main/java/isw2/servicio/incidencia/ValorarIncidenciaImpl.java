package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class ValorarIncidenciaImpl implements ValorarIncidencia {

	private RepositorioIncidenciasImpl ri;

	public ValorarIncidenciaImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
	}

	public Set<Incidencia> listarIncidenciaPorDni(String dni) {
		return ri.buscarIncidenciasPorDni(dni);
	}

	public void registrarValoracion(Integer id, Integer val) {
		ri.getIncidencia(id).getRespuesta().setValoracion(val);
	}

}
