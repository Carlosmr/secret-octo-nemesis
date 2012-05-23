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

public class BajaAsociacionImpl implements BajaAsociacion {

	private RepositorioTecnicos rt;
	private RepositorioProcedimientos rp;
	private Tecnico t;

	public BajaAsociacionImpl() {

		EntityManager em = SingleEntityManager.getEntityManager();

		rt = new RepositorioTecnicosImpl(em);
		rp = new RepositorioProcedimientosImpl(em);

	}

	public Set<Tecnico> listarTecnicosActivos() {

		return rt.getTecnicosDadosDeAlta();
	}

	public Set<Tecnico> listarTecnicos() {

		return rt.getTecnicos();
	}

	public void seleccionaTecnico(String user) {

		this.t = rt.getTecnico(user);
	}

	public Set<Procedimiento> listarProcedimientos() {

		return rp.getProcedimientos();
	}

	public void desasociarProcedimientos(Set<Procedimiento> procedimientos) {

		for (Procedimiento p : procedimientos) {
			t.eliminaProcedimiento(p);
		}

	}

}
