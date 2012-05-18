package isw2.servicio.tecnico;

import java.util.Set;

import isw2.entidades.Procedimiento;
import isw2.entidades.Tecnico;

public interface AltaAsociacion {

	Set<Tecnico> listarTecnicosRegistrados();

	void seleccionarTecnico(String user);

	Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico();

	void asignarProcedimientos(Set<Procedimiento> procedimientos);


}
