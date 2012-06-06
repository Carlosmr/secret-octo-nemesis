package isw2.presentacion.shared;


import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getDadoDeBaja()==false" })
public interface Procedimiento{

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

	@Pre({ "nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException" })
	@Pos({ "getNombre()==nombre", "getCodigo()==getCodigo()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre" })
	void setNombre(String nombre);

	@Pre({ "descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException" })
	@Pos({ "getDescripcion()==descripcion", "getCodigo()==getCodigo()@pre",
			"getNombre()==getNombre()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre" })
	void setDescripcion(String descripcion);

	@Pre({ "dadobaja!=null # NullPointerException" })
	@Pos({ "getDadoDeBaja()==dadobaja", "getCodigo()==getCodigo()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getNombre()==getNombre()@pre" })
	void setDadoDeBaja(boolean dadobaja);


}
