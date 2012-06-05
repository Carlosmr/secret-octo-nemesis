package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.implementaciones.RespuestaImpl;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;

import java.util.Set;



public class ResponderIncidenciaImpl implements ResponderIncidencia {

	private RepositorioIncidenciasImpl ri;
	private Incidencia incidencia;
	private String descripcion;

	public ResponderIncidenciaImpl() {
		ri = new RepositorioIncidenciasImpl();
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
