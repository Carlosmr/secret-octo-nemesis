package isw2.servicio.tecnico;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;

public interface AltaAsociacion {

	Set<Tecnico> listarTecnicosRegistrados();

	void seleccionarTecnico(String user);

	Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico();

	void asignarProcedimientos(Set<String> idProcedimientos);

}
