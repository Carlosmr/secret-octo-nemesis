package isw2.repositorios.persistencia;

import java.util.Collection;
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

		Set<Producto> result = new HashSet<Producto>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<ProductoImpl> clientRepository = getEntityManager()
					.createQuery("from ProductoImpl", ProductoImpl.class)
					.getResultList();
			result = new HashSet<Producto>(clientRepository);
			getEntityManager().getTransaction().commit();

		} catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public void guardar(Producto producto) {

		try {

			getEntityManager().getTransaction().begin();
			getEntityManager().persist(producto);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

	}

	public Producto getProducto(String codigo) {

		Producto result = new ProductoImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = getEntityManager().find(ProductoImpl.class, codigo);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public Set<Producto> getProductosDadosDeAlta() {

		Set<Producto> result = new HashSet<Producto>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Producto> clientRepository = getEntityManager()
					.createQuery(
							"SELECT p FROM ProductoImpl p WHERE p.dadoDeBaja = false",
							Producto.class).getResultList();

			result = new HashSet<Producto>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {
			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

}
