package isw2.repositorios;

import java.util.Set;

import isw2.entidades.contratos.Producto;

public interface RepositorioProductos {

	Producto crearProducto(String codigo, String nombre, String descripcion);

	Set<Producto> getProductos();

	Set<Producto> getProductosDadosDeAlta();

	void guardar(Producto producto);

	Producto getProducto(String codigo);

}
