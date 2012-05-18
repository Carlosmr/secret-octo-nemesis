package isw2.persistencia;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;

public interface Administracion extends ModeloAdministracion {

	@Pre( { "!isLoggedIn()" })
	@Pos( { "isLoggedIn()" })
	void logIn();
}
