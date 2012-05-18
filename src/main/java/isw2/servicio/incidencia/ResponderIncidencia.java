package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.Incidencia;

public interface ResponderIncidencia {

	Set<Incidencia> listarIncidenciasTecnicoSinRespuesta(String user);

	void seleccionarIncidencia(Integer id);

	void añadirDescripcion(String descripcion);

	void registrarRespuesta();
}
