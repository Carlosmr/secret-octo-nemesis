package isw2.repositorios;

import java.util.Set;

import isw2.entidades.contratos.Producto;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

public interface RepositorioProductos {

	@Pre({ "codigo!=\"\" # IllegalArgumentException",
			"codigo!=null # NullPointerException",
			"nombre!=\"\" # IllegalArgumentException",
			"nombre!=null # NullPointerException",
			"descripcion!=\"\" # IllegalArgumentException",
			"descripcion!=null # NullPointerException" })
	@Pos({
			"result.getCodigo()==codigo",
			"result.getNombre()==nombre",
			"result.getDescripcion()==descripcion",
			"getProductos().contains(result)",
			"forall Producto p: getProductos()@Pre � getProductos().contains(p)",
			"getProductos().size()==getProductos().size()@Pre+1" })
	Producto crearProducto(String codigo, String nombre, String descripcion);

	@Query
	@Pre({ "true" })
	Set<Producto> getProductos();
	
	void guardar(Producto producto);
		
	Producto getProducto(String codigo);

}
