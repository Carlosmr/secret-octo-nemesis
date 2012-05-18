package isw2.repositorios;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;

public interface Administracion extends ModeloAdministracion {

	@Pre( { "!isLoggedIn()" })
	@Pos( { "isLoggedIn()" })
	void logIn();
}
