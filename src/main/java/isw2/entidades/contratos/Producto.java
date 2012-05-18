package isw2.entidades.contratos;

import java.io.Serializable;
import java.util.Set;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getDadoDeBaja()==false" })
public interface Producto extends Serializable{

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
	Boolean getDadoDeBaja();

	@Query
	@Pre({ "true" })
	Set<Procedimiento> getProcedimientos();

	@Pre({ "nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException" })
	@Pos({ "getNombre()==nombre", "getCodigo()==getCodigo()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getIncidencias()==getIncidencias()@Pre" })
	void setNombre(String nombre);

	@Pre({ "descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException" })
	@Pos({ "getDescripcion()==descripcion", "getNombre()==getNombre()@Pre",
			"getCodigo()==getCodigo()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getIncidencias()==getIncidencias()@Pre" })
	void setDescripcion(String descripcion);

	@Pre({ "dadobaja!=null # NullPointerException" })
	@Pos({ "getDadoBaja()==dadobaja", "getNombre()==getNombre()@Pre",
			"getCodigo()==getCodigo()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getIncidencias()==getIncidencias()@Pre" })
	void setDadoDeBaja(Boolean dadobaja);

	@Pre({ "procedimiento != null #NullPointerException",
			"!getProcedimientos().contains(procedimiento) #IllegalArgumentException" })
	@Pos({
			"getProcedimiento().contains(procedimiento)",
			"forall Procedimiento p: getProcedimiento()@Pre � getProcedimientos().contains(p)",
			"getProcedimiento().size()==getProcedimiento().size()@Pre+1",
			"getDadoBaja()==getDadoDeBaja()@Pre",
			"getNombre()==getNombre()@Pre", "getCodigo()==getCodigo()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getIncidencias()==getIncidencias()@Pre" })
	void añadirProcedimiento(Procedimiento procedimiento);

	@Pre({ "procedimiento != null #NullPointerException",
			"getProcedimientos().contains(procedimiento) #IllegalArgumentException" })
	@Pos({
			"!getProcedimiento().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@Pre � !p.equals(procedimiento) ==> getProcedimientos().contains(p)",
			"getProcedimiento().size()==getProcedimiento().size()@Pre-1",
			"getDadoBaja()==getDadoDeBaja()@Pre",
			"getNombre()==getNombre()@Pre", "getCodigo()==getCodigo()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getIncidencias()==getIncidencias()@Pre" })
	void eliminarProcedimiento(Procedimiento procedimiento);

}
