package isw2.servicio.tecnico;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AltaAsociacionImpl implements AltaAsociacion {

	RepositorioTecnicos rt;
	RepositorioProcedimientos rp;

	public AltaAsociacionImpl() {

		EntityManager em = Persistence.createEntityManagerFactory("isw2.acme")
				.createEntityManager();
		rt = new RepositorioTecnicosImpl(em);
		rp = new RepositorioProcedimientosImpl(em);

	}

	public Set<Tecnico> listarTecnicosRegistrados() {

		return rt.getTecnicosActivos();

	}

	public void seleccionarTecnico(String user) {
		// TODO Auto-generated method stub

	}

	public Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico() {
		// TODO Auto-generated method stub
		return null;
	}

	public void asignarProcedimientos(Set<Procedimiento> procedimientos) {
		// TODO Auto-generated method stub

	}

}
