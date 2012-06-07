package isw2.servicio.tecnico;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

import java.util.Set;


public class AltaAsociacionImpl implements
		AltaAsociacion {

	/**
	 * 
	 */
	private RepositorioTecnicos rt;
	private RepositorioProcedimientos rp;
	private Tecnico t;

	public AltaAsociacionImpl() {

		rt = new RepositorioTecnicosImpl();
		rp = new RepositorioProcedimientosImpl();

	}

	public Set<Tecnico> listarTecnicosRegistrados() {

		return rt.getTecnicosDadosDeAlta();

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
