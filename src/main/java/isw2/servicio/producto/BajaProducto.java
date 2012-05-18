package isw2.servicio.producto;

import java.util.Set;

import isw2.entidades.contratos.Producto;


public interface BajaProducto {

	Set<Producto> listarProductos();
	
	void darDeBajaProducto(String codigo);

}
