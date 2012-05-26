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
	boolean getDadoDeBaja();

	@Query
	@Pre({ "true" })
	String getTelefono();

	@Query
	@Pre({ "true" })
	Set<Procedimiento> getProcedimientos();

	@Pre({ "nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException" })
	@Pos({ "getNombre()==nombre", "getUser()==getUser()@pre",
			"getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setNombre(String nombre);

	@Pre({ "user!=\"\" # IllegalArgumentException",
			"user!=null # NullPointerException" })
	@Pos({ "getUser()==user", "getNombre()==getNombre()@pre",
			"getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setUser(String user);

	@Pre({ "password.length()>6 # IllegalArgumentException",
			"password!=null # NullPointerException" })
	@Pos({ "getPassword()==password", "getUser()==getUser()@pre",
			"getNombre()==getNombre()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setPassword(String password);

	@Pre({ "apellidos!=\"\" # IllegalArgumentException",
			"apellidos!=null # NullPointerException" })
	@Pos({ "getApellidos()==apellidos", "getUser()==getUser()@pre",
			"getPassword()==getPassword()@pre", "getNombre()==getNombre()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setApellidos(String apellidos);

	@Pre({ "fechaNac!= null # NullPointerException" })
	@Pos({ "getFechaNacimiento()==fechaNac", "getUser()==getUser()@pre",
			"getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getNombre()==getNombre()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setFechaNacimiento(Date fechaNac);

	@Pre({ "direccion!=\"\" # IllegalArgumentException",
			"direccion!=null # NullPointerException" })
	@Pos({ "getDireccion()==direccion", "getUser()==getUser()@pre",
			"getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getNombre()==getNombre()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setDireccion(String direccion);

	@Pre({ "telefono!=null # NullPointerException",
			"telefono.matches(\"\\d{9}(\\d{3}?)\") #IllegalArgumentException" })
	@Pos({ "getTelefono()==telefono", "getUser()==getUser()@pre",
			"getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getNombre()==getNombre()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setTelefono(String telefono);

	@Pre({ "dadobaja!=null # NullPointerException" })
	@Pos({ "getDadoDeBaja()==dadobaja", "getUser()==getUser()@pre",
			"getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getNombre()==getNombre()@pre", "getTelefono()==getTelefono()@pre",
			"getProcedimientos()==getProcedimientos()@pre" })
	void setDadoDeBaja(boolean dadobaja);

	@Pre({ "procedimiento!=null # NullPointerException",
			"getProcedimientos().size()<10 # IllegalArgumentException",
			"!procedimiento.getDadoDeBaja() # IllegalArgumentException",
			"!getProcedimientos().contains(procedimiento) # IllegalArgumentException" })
	@Pos({
			"getProcedimientos().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@pre � getProcedimientos().contains(p)",
			"getProcedimientos().size()==getProcedimientos().size()@pre+1",
			"getUser()==getUser()@pre", "getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getNombre()==getNombre()@pre" })
	void anadirProcedimiento(Procedimiento procedimiento);

	@Pre({ "procedimiento!=null # NullPointerException",
			"getProcedimientos().contains(procedimiento) # IllegalArgumentException" })
	@Pos({
			"!getProcedimientos().contains(procedimiento)",
			"forall Procedimiento p: getProcedimientos()@pre � !p.equals(procedimiento) ==> getProcedimientos().contains(p)",
			"getProcedimientos().size()==getProcedimientos().size()@pre-1",
			"getUser()==getUser()@pre", "getPassword()==getPassword()@pre",
			"getApellidos()==getApellidos()@pre",
			"getFechaNacimiento()==getFechaNacimiento()@pre",
			"getDireccion()==getDireccion()@pre",
			"getDadoDeBaja()==getDadoDeBaja()@pre",
			"getTelefono()==getTelefono()@pre",
			"getNombre()==getNombre()@pre" })
	void eliminaProcedimiento(Procedimiento procedimiento);

}
