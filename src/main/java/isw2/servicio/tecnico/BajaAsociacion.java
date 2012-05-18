package isw2.servicio.tecnico;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;

public interface BajaAsociacion {

	
	Set<Tecnico> listarTecnicos();
	
	void seleccionaTecnico(String user);
	
	Set<Procedimiento> listarProcedimientos();
	
	void desasociarProcedimientos(Set<Procedimiento> procedimientos);

}
