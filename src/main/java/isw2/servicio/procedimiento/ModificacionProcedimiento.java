package isw2.servicio.procedimiento;

import java.util.Set;

import isw2.entidades.Procedimiento;

public interface ModificacionProcedimiento {

	Set<Procedimiento> listarProcedimientos();
	
	Procedimiento seleccionaProcedimiento(String codigo);
	
	void guardarDatosProcedimiento(String nombre, String descripcion);
}
