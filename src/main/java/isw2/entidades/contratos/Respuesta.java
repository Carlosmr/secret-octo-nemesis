package isw2.entidades.contratos;

import java.io.Serializable;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getValoracion()==0" })
@Inv({ "getValoracion()>=-5 && getValoracion()<=5" })
public interface Respuesta extends Serializable{

	@Query
	@Pre({ "true" })
	Integer getValoracion();

	@Pre({ "val!=null # NullPointerException",
			"val>=-5 && val <=5 # IllegalArgumentException" })
	@Pos({ "getValoracion()==val", "getDescripcion()==getDescripcion()@Pre",
			"getIncidencia()==getIncidencia()@Pre" })
	void setValoracion(Integer val);

	@Query
	@Pre({ "true" })
	String getDescripcion();

}
