package isw2.repositorios;

import java.util.Date;
import java.util.Set;

import isw2.entidades.contratos.ModeloTecnico;
import isw2.entidades.contratos.Tecnico;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

public interface RepositorioTecnicos extends ModeloTecnico {

	@Pre({ "user!=\"\" # IllegalArgumentException",
			"user!=null # NullPointerException",
			"password.length>6 # IllegalArgumentException",
			"password!=null # NullPointerException",
			"nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException",
			"apellidos!=\"\" # IllegalArgumentException",
			"apellidos!=null # NullPointerException",
			"fechaNac!= null # NullPointerException",
			"direccion!=\"\" # IllegalArgumentException",
			"direccion!=null # NullPointerException",
			"telefono!=null # NullPointerException",
			"telefono.matches(\"\\d{9}\\d{3}?\")" })
	@Pos({
			"result.getUser()==user",
			"result.getPassword()==password",
			"result.getNombre()==nombre",
			"result.getApellidos()==apellidos",
			"result.getFechaNacimiento()==fechaNac",
			"result.getDireccion()==direccion",
			"result.getTelefono()==telefono",
			"getTecnicos().contains(result)",
			"!result.getDadoDeBaja()",
			"result.getProcedimientos().size()==0",
			"result.getIncidencias().size()==0",
			"forall Tecnico t: getTecnicos()@Pre � getTecnicos().contains(t)",
			"getTecnicos().size()==getTecnicos().size()@Pre+1" })
	Tecnico crearTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono);

	@Pre({ "!isTecnicoLogged()",
			"credencialesValidos(user, password) # IllegalArgumentException" })
	@Pos({ "isTecnicoLogged()", "getTecnicos()==getTecnicos()@Pre" })
	void logIn(String user, String password);

	@Query
	@Pre({ "true" })
	Set<Tecnico> getTecnicos();

	Set<Tecnico> getTecnicosDadosDeAlta();

	void guardar(Tecnico tecnico);

	Tecnico getTecnico(String user);
}
