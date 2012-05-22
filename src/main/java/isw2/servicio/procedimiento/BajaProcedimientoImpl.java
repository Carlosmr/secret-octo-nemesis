package isw2.servicio.procedimiento;

import isw2.entidades.contratos.Procedimiento;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class BajaProcedimientoImpl implements BajaProcedimiento {

	private RepositorioProcedimientosImpl rp;

	public BajaProcedimientoImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		rp = new RepositorioProcedimientosImpl(em);
	}

	public Set<Procedimiento> listarProcedimientos() {
		return rp.getProcedimientos();
	}

	public void darDeBajaProcedimiento(String codigo) {
		rp.getProcedimiento(codigo).setDadoDeBaja(true);
	}

}
