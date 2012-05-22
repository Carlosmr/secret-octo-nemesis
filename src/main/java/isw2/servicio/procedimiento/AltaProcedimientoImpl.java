package isw2.servicio.procedimiento;

import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import javax.persistence.EntityManager;

public class AltaProcedimientoImpl implements AltaProcedimiento {

	private RepositorioProcedimientosImpl rp;

	public AltaProcedimientoImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		rp = new RepositorioProcedimientosImpl(em);
	}

	public void introducirDatosProcedimiento(String codigo, String nombre,
			String descripcion) {
		rp.crearProcedimiento(codigo, nombre, descripcion);

	}

}
