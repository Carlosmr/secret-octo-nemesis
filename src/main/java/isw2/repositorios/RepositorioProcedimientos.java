package isw2.repositorios;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

public interface RepositorioProcedimientos {

	@Pre({ "codigo!=\"\" # IllegalArgumentException",
			"codigo!=null # NullPointerException",
			"nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException",
			"descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException", })
	@Pos({
			"result.getCodigo()==codigo",
			"result.getNombre()==nombre",
			"result.getDescripcion()==descripcion",
			"result.getProductos().size()==0",
			"result.getIncidencias().size()==0",
			"result.getTecnicos().size()==0",
			"!result.getDadoDeBaja()",
			"getProcedimientos().contains(result)",
			"forall Procedimiento p: getProcedimientos()@Pre � getProcedimientos().contains(t)",
			"getProcedimientos().size()==getProcedimientos().size()@Pre+1" })
	Procedimiento crearProcedimiento(String codigo, String nombre,
			String descripcion);

	@Query
	@Pre({ "true" })
	Set<Procedimiento> getProcedimientos();

	Set<Procedimiento> getProcedimientosNoAsociadosAlTecnico(String user);

	void guardar(Procedimiento procedimiento);

	Procedimiento getProcedimiento(String codigo);

}
