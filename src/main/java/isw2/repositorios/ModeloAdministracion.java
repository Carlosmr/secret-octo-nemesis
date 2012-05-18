package isw2.repositorios;

import tdg.contract.semanticAnnotations.Model;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Model
public interface ModeloAdministracion {

	@Query
	@Pre( { "true" })
	Boolean isLoggedIn();
}
