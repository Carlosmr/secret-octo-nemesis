package isw2.repositorios;

import java.util.Date;
import java.util.Set;

import isw2.entidades.contratos.Incidencia;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

public interface RepositorioIncidencias {

	@Query
	@Pre({ "true" })
	Set<Incidencia> buscarIncidenciasPorDni(String dni);

	@Pre({ "busqueda!=\"\" # IllegalArgumentException",
			"busqueda!=null # NullPointerException", "" })
	Set<Incidencia> buscarIncidencia(String busqueda);

	@Pre({ "nombreCliente!=\"\" # IllegalArgumentException",
			"nombreCliente!=null # NullPointerException",
			"dni!=\"\" # IllegalArgumentException",
			"dni!=null # NullPointerException", "dniEsvalido(dni)",
			"email!=\"\" # IllegalArgumentException",
			"email!=null # NullPointerException",
			"email.matches(\" [A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4} \")",
			"descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException",
			"fechaCompra!=null # NullPointerException", })
	@Pos({
			"result.getNombreCliente()==nombreCliente",
			"result.getDNI()==dni",
			"result.getEmail()==email",
			"result.getDescripcion()==descripcion",
			"result.getFechaCompra()==fechaCompra",
			"getIncidencias().contains(result)",
			"forall Incidencia i: getIncidencias()@Pre � getIncidencias().contains(i)",
			"getIncidencias().size()==getIncidencias().size()@Pre+1" })
	Incidencia crearIncidencia(String nombreCliente, String dni, String email,
			String descripcion, Date fechaCompra);

	@Query
	@Pre({ "true" })
	Set<Incidencia> getIncidencias();
	
	void guardar(Incidencia incidencia);
	
	Incidencia getIncidencia(Integer id);
	
	/**
	 * Obtiene las incidencias que est�n asignadas al t�cnico con usuario igual a user.
	 **/
	Set<Incidencia> getIncidencias(String user);

}
