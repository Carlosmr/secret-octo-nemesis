package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.contratos.Incidencia;

public interface AsignarIncidencia {

	Set<Incidencia> listarIncidenciasSinAsignar(String user);

	void asociarIncidencia(Set<Integer> incidencias);

}
