package isw2.repositorios;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;

public interface RepositorioProcedimientos {

	Procedimiento crearProcedimiento(String codigo, String nombre,
			String descripcion);

	Set<Procedimiento> getProcedimientosDadosDeAlta();

	Set<Procedimiento> getProcedimientosNoAsociadosAlTecnico(String user);

	void guardar(Procedimiento procedimiento);

	Procedimiento getProcedimiento(String codigo);

}
