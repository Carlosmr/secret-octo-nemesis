package isw2.servicio.producto;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;

public interface ModificacionProducto {

	Set<Producto> listarProductos();

	Set<Producto> listarProductosDadosDeAlta();

	Producto seleccionaProducto(String codigo);

	void guardarDatosProducto(String nombre, String descripcion);

	Set<Procedimiento> listarProcedimientos();

	void guardarProcedimientos(Set<Procedimiento> procedimientos);
}
