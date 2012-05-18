package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.contratos.Incidencia;

public interface ObtenerInformacionIncidencia {

	Set<Incidencia> listarIncidencias();
	
	Incidencia seleccionarIncidencia(Integer id);
}
