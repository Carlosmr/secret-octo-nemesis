package isw2.entidades;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getDadoDeBaja()==false" })
public interface Procedimiento {

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

	@Pre({ "nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException" })
	@Pos({ "getNombre()==nombre", "getCodigo()==getCodigo()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getProductos()==getProductos()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getTecnicos()==getTecnicos()@Pre" })
	void setNombre(String nombre);

	@Pre({ "descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException" })
	@Pos({ "getDescripcion()==descripcion", "getCodigo()==getCodigo()@Pre",
			"getNombre()==getNombre()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getProductos()==getProductos()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getTecnicos()==getTecnicos()@Pre" })
	void setDescripcion(String descripcion);

	@Pre({ "dadobaja!=null # NullPointerException" })
	@Pos({ "getDadoDeBaja()==dadobaja", "getCodigo()==getCodigo()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getNombre()==getNombre()@Pre",
			"getProductos()==getProductos()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getTecnicos()==getTecnicos()@Pre" })
	void setDadoDeBaja(Boolean dadobaja);


}
