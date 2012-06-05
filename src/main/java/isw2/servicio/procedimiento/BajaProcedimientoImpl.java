package isw2.servicio.procedimiento;

import isw2.entidades.contratos.Procedimiento;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;

import java.util.Set;

public class BajaProcedimientoImpl implements BajaProcedimiento {

	private RepositorioProcedimientosImpl rp;

	public BajaProcedimientoImpl() {
		rp = new RepositorioProcedimientosImpl();
	}

	public Set<Procedimiento> listarProcedimientos() {
		return rp.getProcedimientos();
	}

	public void darDeBajaProcedimiento(String codigo) {
		rp.getProcedimiento(codigo).setDadoDeBaja(true);
	}

}
