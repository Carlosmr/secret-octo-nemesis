package isw2.servicio.producto;

import isw2.entidades.contratos.Producto;
import isw2.repositorios.persistencia.RepositorioProductosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Set;

import javax.persistence.EntityManager;

public class BajaProductoImpl implements BajaProducto {

	private RepositorioProductosImpl rp;

	public BajaProductoImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		rp = new RepositorioProductosImpl(em);
	}

	public Set<Producto> listarProductos() {
		return rp.getProductos();
	}

	public void darDeBajaProducto(String codigo) {
		rp.getProducto(codigo).setDadoDeBaja(true);
	}

}
