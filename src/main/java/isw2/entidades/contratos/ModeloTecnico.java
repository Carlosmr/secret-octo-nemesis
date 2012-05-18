package isw2.entidades.contratos;

import tdg.contract.semanticAnnotations.Model;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Model
public interface ModeloTecnico {

	/**
	 * Comprueba si los credenciales proporcionados son v�lidos.
	 **/
	@Query
	@Pre({ "true" })
	Boolean credencialesValidos(String user, String password);

	/**
	 * Comprueba si el t�cnico est� loggeado.
	 **/
	@Query
	@Pre({ "true" })
	Boolean isTecnicoLogged();
}
