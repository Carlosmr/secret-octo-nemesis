package isw2.servicio.procedimiento;

import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;

public class AltaProcedimientoImpl implements AltaProcedimiento {

	private RepositorioProcedimientosImpl rp;

	public AltaProcedimientoImpl() {
		rp = new RepositorioProcedimientosImpl();
	}

	public void introducirDatosProcedimiento(String codigo, String nombre,
			String descripcion) {
		rp.guardar(rp.crearProcedimiento(codigo, nombre, descripcion));

	}

}
