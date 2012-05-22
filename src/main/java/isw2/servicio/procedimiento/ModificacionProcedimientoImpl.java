package isw2.servicio.procedimiento;

import isw2.entidades.contratos.Procedimiento;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class ModificacionProcedimientoImpl implements ModificacionProcedimiento {

	private RepositorioProcedimientosImpl rp;
	private Procedimiento procedimiento;

	public ModificacionProcedimientoImpl(){
		EntityManager em = SingleEntityManager.getEntityManager();
		rp = new RepositorioProcedimientosImpl(em);
	}
	
	public Set<Procedimiento> listarProcedimientos() {
		return rp.getProcedimientos();
	}

	public Procedimiento seleccionaProcedimiento(String codigo) {
		procedimiento =rp.getProcedimiento(codigo);
		return procedimiento;
	}

	public void guardarDatosProcedimiento(String nombre, String descripcion) {
		procedimiento.setNombre(nombre);
		procedimiento.setDescripcion(descripcion);
	}

}
