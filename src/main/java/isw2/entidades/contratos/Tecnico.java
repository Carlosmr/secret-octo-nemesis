package isw2.entidades.contratos;

import java.util.Date;
import java.util.Set;
import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({ "getDadoDeBaja()==false" })
@Inv({ "getProcedimientos().size()<=10" })
public interface Tecnico{

	@Query
	@Pre({ "true" })
	String getUser();

	@Query
	@Pre({ "true" })
	String getPassword();

	@Query
	@Pre({ "true" })
	String getNombre();

	@Query
	@Pre({ "true" })
	String getApellidos();

	@Query
	@Pre({ "true" })
	Date getFechaNacimiento();

	@Query
	@Pre({ "true" })
	String getDireccion();

	@Query
	@Pre({ "true" })
	Boolean getDadoDeBaja();

	@Query
	@Pre({ "true" })
	String getTelefono();

	@Query
	@Pre({ "true" })
	Set<Procedimiento> getProcedimientos();

	@Pre({ "nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException" })
	@Pos({ "getNombre()==nombre", "getUser()==getUser()@Pre",
			"getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setNombre(String nombre);

	@Pre({ "user!=\"\" # IllegalArgumentException",
			"user!=null # NullPointerException" })
	@Pos({ "getUser()==user", "getNombre()==getNombre()@Pre",
			"getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setUser(String user);

	@Pre({ "password.length>6 # IllegalArgumentException",
			"password!=null # NullPointerException" })
	@Pos({ "getPassword()==password", "getUser()==getUser()@Pre",
			"getNombre()==getNombre()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setPassword(String password);

	@Pre({ "apellidos!=\"\" # IllegalArgumentException",
			"apellidos!=null # NullPointerException" })
	@Pos({ "getApellidos()==apellidos", "getUser()==getUser()@Pre",
			"getPassword()==getPassword()@Pre", "getNombre()==getNombre()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setApellidos(String apellidos);

	@Pre({ "fechaNac!= null # NullPointerException" })
	@Pos({ "getFechaNacimiento()==fechaNac", "getUser()==getUser()@Pre",
			"getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getNombre()==getNombre()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setFechaNacimiento(Date fechaNac);

	@Pre({ "direccion!=\"\" # IllegalArgumentException",
			"direccion!=null # NullPointerException" })
	@Pos({ "getDireccion()==direccion", "getUser()==getUser()@Pre",
			"getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getNombre()==getNombre()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setDireccion(String direccion);

	@Pre({ "telefono!=null # NullPointerException",
			"telefono.matches(\"\\d{9}(\\d{3}?)\") #IllegalArgumentException" })
	@Pos({ "getTelefono()==telefono", "getUser()==getUser()@Pre",
			"getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getNombre()==getNombre()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setTelefono(String telefono);

	@Pre({ "dadobaja!=null # NullPointerException" })
	@Pos({ "getDadoDeBaja()==dadobaja", "getUser()==getUser()@Pre",
			"getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getNombre()==getNombre()@Pre", "getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getProcedimientos()==getProcedimientos()@Pre" })
	void setDadoDeBaja(Boolean dadobaja);

	@Pre({ "procedimiento!=null # NullPointerException",
			"getProcedimientos().size()<10 # IllegalArgumentException",
			"!procedimiento.getDadoDeBaja() # IllegalArgumentException",
			"!getProcedimientos().contains(procedimiento) # IllegalArgumentException" })
	@Pos({
			"getProcedimientos().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@Pre � getProcedimientos().contains(p)",
			"getProcedimientos().size()==getProcedimientos().size()@Pre+1",
			"getUser()==getUser()@Pre", "getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getNombre()==getNombre()@Pre" })
	void anadirProcedimiento(Procedimiento procedimiento);

	@Pre({ "procedimiento!=null # NullPointerException",
			"getProcedimientos().contains(procedimiento) # IllegalArgumentException" })
	@Pos({
			"!getProcedimientos().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@Pre � !p.equals(procedimiento) ==> getProcedimientos().contains(p)",
			"getProcedimientos().size()==getProcedimientos().size()@Pre-1",
			"getUser()==getUser()@Pre", "getPassword()==getPassword()@Pre",
			"getApellidos()==getApellidos()@Pre",
			"getFechaNacimiento()==getFechaNacimiento()@Pre",
			"getDireccion()==getDireccion()@Pre",
			"getDadoDeBaja()==getDadoDeBaja()@Pre",
			"getTelefono()==getTelefono()@Pre",
			"getIncidencias()==getIncidencias()@Pre",
			"getNombre()==getNombre()@Pre" })
	void eliminaProcedimiento(Procedimiento procedimiento);

}
