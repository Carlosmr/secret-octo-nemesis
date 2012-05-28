package isw2.repositorios;

import java.util.Date;
import java.util.Set;

import isw2.entidades.contratos.Incidencia;

public interface RepositorioIncidencias {

	Set<Incidencia> buscarIncidenciasPorDni(String dni);

	Set<Incidencia> buscarIncidencia(String busqueda);

	Incidencia crearIncidencia(String nombreCliente, String dni, String email,
			String descripcion, Date fechaCompra);

	Set<Incidencia> getIncidencias();

	void guardar(Incidencia incidencia);

	Incidencia getIncidencia(Integer id);

	Set<Incidencia> getIncidenciasSinAsignar();

	Set<Incidencia> getIncidenciasSinRespuesta(String user);

	/**
	 * Obtiene las incidencias que esten asignadas al tecnico con usuario igual
	 * a user.
	 **/
	Set<Incidencia> getIncidencias(String user);

}
