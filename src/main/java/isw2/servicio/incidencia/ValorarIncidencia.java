package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.contratos.Incidencia;

public interface ValorarIncidencia {

	Set<Incidencia> listarIncidenciaPorDni(String dni);

	void registrarValoracion(Integer val);

}
