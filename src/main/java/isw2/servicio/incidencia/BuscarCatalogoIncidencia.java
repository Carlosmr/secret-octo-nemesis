package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.Incidencia;

public interface BuscarCatalogoIncidencia {

	Set<Incidencia> busquedaParaIncidencia(String busqueda);

}
