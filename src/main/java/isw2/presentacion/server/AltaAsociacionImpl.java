package isw2.presentacion.server;

import isw2.presentacion.client.AltaAsociacion;
import isw2.presentacion.shared.Procedimiento;
import isw2.presentacion.shared.Tecnico;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AltaAsociacionImpl extends RemoteServiceServlet implements
		AltaAsociacion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -684489499547037848L;
	private RepositorioTecnicos rt;
	private RepositorioProcedimientos rp;
	private Tecnico t;

	public AltaAsociacionImpl() {

		rt = new RepositorioTecnicosImpl();
		rp = new RepositorioProcedimientosImpl();

	}

	public Set<Tecnico> listarTecnicosRegistrados() {

		Set<Tecnico> tecnicos = new HashSet<Tecnico>();
		rt.guardar(rt.crearTecnico("benito", "perez", "benito", "perez",
				new Date(), "", ""));
		rt.guardar(rt.crearTecnico("lopera", "perez", "benito", "perez",
				new Date(), "", ""));
		rt.guardar(rt.crearTecnico("nigger", "perez", "benito", "perez",
				new Date(), "", ""));
		rt.guardar(rt.crearTecnico("manolo", "perez", "benito", "perez",
				new Date(), "", ""));

		tecnicos.addAll(rt.getTecnicosDadosDeAlta());
		return tecnicos;

	}

	public void seleccionarTecnico(String user) {

		this.t = rt.getTecnico(user);

	}

	public Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico() {

		return rp.getProcedimientosNoAsociadosAlTecnico(this.t.getUser());
	}

	public void asignarProcedimientos(Set<String> idProcedimientos) {

		for (String s : idProcedimientos)
			t.anadirProcedimiento(rp.getProcedimiento(s));

	}
}
