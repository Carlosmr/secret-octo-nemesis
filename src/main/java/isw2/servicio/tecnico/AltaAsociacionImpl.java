package isw2.servicio.tecnico;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class AltaAsociacionImpl implements AltaAsociacion {

	private RepositorioTecnicos rt;
	private RepositorioProcedimientos rp;
	private Tecnico t;

	public AltaAsociacionImpl() {

		EntityManager em = SingleEntityManager.getEntityManager();

		rt = new RepositorioTecnicosImpl(em);
		rp = new RepositorioProcedimientosImpl(em);

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

	public void asignarProcedimientos(Set<Procedimiento> procedimientos) {

		for (Procedimiento p : procedimientos) {

			t.anadirProcedimiento(p);
		}

	}
}
