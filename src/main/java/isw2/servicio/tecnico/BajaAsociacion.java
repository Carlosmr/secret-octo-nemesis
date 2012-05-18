package isw2.servicio.tecnico;

import java.util.Set;

import isw2.entidades.Procedimiento;
import isw2.entidades.Tecnico;

public interface BajaAsociacion {

	
	Set<Tecnico> listarTecnicos();
	
	void seleccionaTecnico(String user);
	
	Set<Procedimiento> listarProcedimientos();
	
	void desasociarProcedimientos(Set<Procedimiento> procedimientos);

}
