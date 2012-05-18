package isw2.servicio.procedimiento;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;

public interface BajaProcedimiento {

	Set<Procedimiento> listarProcedimientos();
	
	void darDeBajaProcedimiento(String codigo);
	
}
