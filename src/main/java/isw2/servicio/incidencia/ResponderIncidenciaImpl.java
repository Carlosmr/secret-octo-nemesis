package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.implementaciones.RespuestaImpl;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class ResponderIncidenciaImpl implements ResponderIncidencia {

	private RepositorioIncidenciasImpl ri;
	private Incidencia incidencia;
	private String descripcion;

	public ResponderIncidenciaImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
	}

	public Set<Incidencia> listarIncidenciasTecnicoSinRespuesta(String user) {
		return ri.getIncidenciasSinRespuesta(user);
	}

	public void seleccionarIncidencia(Integer id) {
		incidencia = ri.getIncidencia(id);
	}

	public void anadirDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void registrarRespuesta() {
		
		Respuesta r = new RespuestaImpl(descripcion);
		try {
			incidencia.setRespuesta(r);
		} catch (InvalidStateException e) {
			e.printStackTrace();
		}
	}

}
