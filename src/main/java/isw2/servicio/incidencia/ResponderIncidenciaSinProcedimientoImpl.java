package isw2.servicio.incidencia;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.implementaciones.RespuestaImpl;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

public class ResponderIncidenciaSinProcedimientoImpl implements
		ResponderIncidenciaSinProcedimiento {

	private RepositorioTecnicosImpl rt;

	public ResponderIncidenciaSinProcedimientoImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		rt = new RepositorioTecnicosImpl(em);
	}

	public void responderIncidenciaSinMantenimiento(Incidencia i) {
		Respuesta r = new RespuestaImpl("Respuesta a Procedimiento automático.");

		try {
			i.setTecnico(rt.getTecnico("SYSTEM"));
			i.setRespuesta(r);
		} catch (InvalidStateException e) {
			e.printStackTrace();
		}
	}

}
