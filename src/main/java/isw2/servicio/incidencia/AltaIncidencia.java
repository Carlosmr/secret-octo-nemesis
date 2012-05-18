package isw2.servicio.incidencia;

import java.util.Set;

import isw2.entidades.Incidencia;
import isw2.entidades.Procedimiento;
import isw2.entidades.Producto;

public interface AltaIncidencia {

	Set<Incidencia> seleccionarIncidenciasUsuario(String nombre, String dni,
			String correo);

	void seleccionarIncidenciasRelacionadas(Set<Incidencia> incidencias);

	Set<Producto> listarProductos();

	void seleccionarProducto(String codigo);

	void introducirDescripcionIncidencia(String descripcion);
	
	Set<Procedimiento> listarProcedimientos();
	
	void seleccionarProcedimiento(String codigo);

	void registrarIncidencia();

}
