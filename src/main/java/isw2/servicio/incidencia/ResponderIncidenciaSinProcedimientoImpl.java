package isw2.servicio.incidencia;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.implementaciones.RespuestaImpl;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

public class ResponderIncidenciaSinProcedimientoImpl implements
		ResponderIncidenciaSinProcedimiento {

	private RepositorioIncidenciasImpl ri;
	private RepositorioTecnicosImpl rt;

	public ResponderIncidenciaSinProcedimientoImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
		rt = new RepositorioTecnicosImpl(em);
	}

	public void responderIncidenciaSinMantenimiento(Integer id) {
		Incidencia i = ri.getIncidencia(id);
		Respuesta r = new RespuestaImpl("Respuesta a Procedimiento automático.");

		try {
			i.setTecnico(rt.getTecnico("SYSTEM"));
			i.setRespuesta(r);
		} catch (InvalidStateException e) {
			e.printStackTrace();
		}
	}

}
