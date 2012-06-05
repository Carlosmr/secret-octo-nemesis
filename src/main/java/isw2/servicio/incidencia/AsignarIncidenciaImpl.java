package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Tecnico;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

import java.util.HashSet;
import java.util.Set;


public class AsignarIncidenciaImpl implements AsignarIncidencia {

	private RepositorioIncidenciasImpl ri;
	private RepositorioTecnicosImpl rt;
	private Tecnico tecnico;

	public AsignarIncidenciaImpl() {
		ri = new RepositorioIncidenciasImpl();
		rt = new RepositorioTecnicosImpl();
	}

	public Set<Incidencia> listarIncidenciasSinAsignar(String user) {
		this.tecnico = rt.getTecnico(user);
		Set<Incidencia> incidencias = ri.getIncidenciasSinAsignar();
		Set<Incidencia> res = new HashSet<Incidencia>();
		for (Incidencia i : incidencias)
			if (tecnico.getProcedimientos().contains(i.getProcedimiento()))
				res.add(i);
		return res;
	}

	public void asociarIncidencia(Set<Integer> incidencias) {
		for (Integer e : incidencias) {
			Incidencia incidencia = ri.getIncidencia(e);
			try {
				incidencia.setTecnico(tecnico);
			} catch (InvalidStateException ex) {
				ex.printStackTrace();
			}
		}
	}

}
