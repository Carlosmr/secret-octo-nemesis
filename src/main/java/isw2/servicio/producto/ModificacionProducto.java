package isw2.servicio.producto;

import java.util.Set;

import isw2.entidades.Procedimiento;
import isw2.entidades.Producto;

public interface ModificacionProducto {

	Set<Producto> listarProductos();

	Producto seleccionaProducto(String codigo);

	void guardarDatosProducto(String nombre, String descripcion);

	Set<Procedimiento> listarProcedimientos();

	void guardarProcedimientos(Set<Procedimiento> procedimientos);
}
