package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.contratos.Incidencia;

public interface ResponderIncidencia {

	Set<Incidencia> listarIncidenciasTecnicoSinRespuesta(String user);

	void seleccionarIncidencia(Integer id);

	void anadirDescripcion(String descripcion);

	void registrarRespuesta();
}
