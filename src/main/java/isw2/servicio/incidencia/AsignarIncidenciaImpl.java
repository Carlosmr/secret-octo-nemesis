package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Tecnico;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class AsignarIncidenciaImpl implements AsignarIncidencia {

	private RepositorioIncidenciasImpl ri;
	private RepositorioTecnicosImpl rt;
	private Incidencia incidencia;

	public AsignarIncidenciaImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
		rt = new RepositorioTecnicosImpl(em);
	}

	public Set<Incidencia> listarIncidenciasSinAsignar() {
		return ri.getIncidenciasSinAsignar();
	}

	public void seleccionarIncidencia(Integer idIncidencia) {
		incidencia = ri.getIncidencia(idIncidencia);
	}

	public void asociarIncidenciaTecnico(String user) {
		Tecnico t = rt.getTecnico(user);
		try {
			incidencia.setTecnico(t);
		} catch (InvalidStateException e) {
			e.printStackTrace();
		}
	}

}
