package isw2.servicio.producto;

import isw2.entidades.contratos.Producto;
import isw2.repositorios.persistencia.RepositorioProductosImpl;
import java.util.Set;

public class BajaProductoImpl implements BajaProducto {

	private RepositorioProductosImpl rp;

	public BajaProductoImpl() {
		rp = new RepositorioProductosImpl();
	}

	public Set<Producto> listarProductos() {
		return rp.getProductos();
	
	}
	
	public Set<Producto> listarProductosDadosDeAlta() {
		return rp.getProductosDadosDeAlta();
	}

	public void darDeBajaProducto(String codigo) {
		rp.getProducto(codigo).setDadoDeBaja(true);
	}

}
