package isw2.servicio.producto;

import java.util.Set;

import isw2.entidades.contratos.Procedimiento;

public interface AltaProducto {

	void datosProducto(String codigo, String nombre, String descripcion);

	Set<Procedimiento> listarProcedimientos();

	Set<Procedimiento> listarProcedimientosDadosDeAlta();

	void seleccionarProcedimientos(Set<String> idProcedimientos);

	void registrarProducto();

}
