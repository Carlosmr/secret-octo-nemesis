package isw2.servicio.producto;

import java.util.Set;

import isw2.entidades.contratos.Producto;

public interface BajaProducto {

	Set<Producto> listarProductos();

	Set<Producto> listarProductosDadosDeAlta();

	void darDeBajaProducto(String codigo);

}
