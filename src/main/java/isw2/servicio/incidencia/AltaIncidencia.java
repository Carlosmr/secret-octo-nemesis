package isw2.servicio.incidencia;

import java.util.Date;
import java.util.Set;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;

public interface AltaIncidencia {

	Set<Incidencia> seleccionarIncidenciasUsuario(String nombre, String dni,
			String email, Date fechaCompra);

	void seleccionarIncidenciasRelacionadas(Set<Integer> incidencias);

	Set<Producto> listarProductos();

	void seleccionarProducto(String codigo);

	void introducirDescripcionIncidencia(String descripcion);

	Set<Procedimiento> listarProcedimientos();

	void seleccionarProcedimiento(String codigo);

	void registrarIncidencia();

}
