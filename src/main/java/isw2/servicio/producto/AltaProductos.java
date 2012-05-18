package isw2.servicio.producto;

import java.util.Set;

import isw2.entidades.Procedimiento;

public interface AltaProductos {

	void datosProducto(String codigo, String nombre, String descripcion);

	Set<Procedimiento> listarProcedimientos();

	void seleccionarProcedimientos(Set<String> idProcedimientos);

	void registrarProducto();

}
