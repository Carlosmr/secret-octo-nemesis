package isw2.entidades.contratos;

import java.util.Set;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getDadoDeBaja()==false" })
public interface Producto{

	@Query
	@Pre({ "true" })
	String getCodigo();

	@Query
	@Pre({ "true" })
	String getNombre();

	@Query
	@Pre({ "true" })
	String getDescripcion();

	@Query
	@Pre({ "true" })
	boolean getDadoDeBaja();

	@Query
	@Pre({ "true" })
	Set<Procedimiento> getProcedimientos();

	@Pre({ "nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException" })
	@Pos({ "getNombre()==nombre", "getCodigo()==getCodigo()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getProcedimientos()==getProcedimientos()@pre"})
	void setNombre(String nombre);

	@Pre({ "descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException" })
	@Pos({ "getDescripcion()==descripcion", "getNombre()==getNombre()@pre",
			"getCodigo()==getCodigo()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getProcedimientos()==getProcedimientos()@pre"})
	void setDescripcion(String descripcion);


	@Pos({ "getDadoBaja()==dadobaja", "getNombre()==getNombre()@pre",
			"getCodigo()==getCodigo()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setDadoDeBaja(boolean dadobaja);

	@Pre({ "procedimiento != null #NullPointerException",
			"!getProcedimientos().contains(procedimiento) #IllegalArgumentException" })
	@Pos({
			"getProcedimientos().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@pre � getProcedimientos().contains(p)",
			"getProcedimientos().size()==getProcedimientos().size()@pre+1",
			"getDadoBaja()==getDadoDeBaja()@pre",
			"getNombre()==getNombre()@pre", "getCodigo()==getCodigo()@pre",
			"getDescripcion()==getDescripcion()@pre"})
	void anadirProcedimiento(Procedimiento procedimiento);

	@Pre({ "procedimiento != null #NullPointerException",
			"getProcedimientos().contains(procedimiento) #IllegalArgumentException" })
	@Pos({
			"!getProcedimientos().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@pre � !p.equals(procedimiento) ==> getProcedimientos().contains(p)",
			"getProcedimientos().size()==getProcedimientos().size()@pre-1",
			"getDadoBaja()==getDadoDeBaja()@pre",
			"getNombre()==getNombre()@pre", "getCodigo()==getCodigo()@pre",
			"getDescripcion()==getDescripcion()@pre"})
	void eliminarProcedimiento(Procedimiento procedimiento);

}
