package isw2.repositorios.persistencia;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Producto;
import isw2.entidades.implementaciones.ProductoImpl;
import isw2.repositorios.RepositorioProductos;

public class RepositorioProductosImpl extends RepositorioJPA implements
		RepositorioProductos {

	public RepositorioProductosImpl(EntityManager em) {
		super(em);
	}

	public Producto crearProducto(String codigo, String nombre,
			String descripcion) {
		return new ProductoImpl(codigo, nombre, descripcion);
	}

	public Set<Producto> getProductos() {
		return new HashSet<Producto>(getEntityManager().createQuery(
				"from Producto", Producto.class).getResultList());
	}

	public void guardar(Producto producto) {
		getEntityManager().persist(producto);
	}

	public Producto getProducto(String codigo) {
		return getEntityManager().find(Producto.class, codigo);
	}

}
