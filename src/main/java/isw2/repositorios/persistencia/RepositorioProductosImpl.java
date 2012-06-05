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

	public RepositorioProductosImpl() {
	}

	public Producto crearProducto(String codigo, String nombre,
			String descripcion) {

		return new ProductoImpl(codigo, nombre, descripcion);

	}

	public Set<Producto> getProductos() {

		EntityManager em = getEntityManager();
		Set<Producto> result = new HashSet<Producto>();

		try {

			em.getTransaction().begin();
			Collection<ProductoImpl> clientRepository = em.createQuery(
					"from ProductoImpl", ProductoImpl.class).getResultList();
			result = new HashSet<Producto>(clientRepository);
			em.getTransaction().commit();

		} catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;

	}

	public void guardar(Producto producto) {
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();

		}

		catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Producto getProducto(String codigo) {
		EntityManager em = getEntityManager();

		Producto result = new ProductoImpl();

		try {

			em.getTransaction().begin();
			result = em.find(ProductoImpl.class, codigo);
			em.getTransaction().commit();

		}

		catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;

	}

	public Set<Producto> getProductosDadosDeAlta() {
		EntityManager em = getEntityManager();
		Set<Producto> result = new HashSet<Producto>();

		try {

			em.getTransaction().begin();
			Collection<Producto> clientRepository = em.createQuery(
					"SELECT p FROM ProductoImpl p WHERE p.dadoDeBaja = false",
					Producto.class).getResultList();

			result = new HashSet<Producto>(clientRepository);
			em.getTransaction().commit();

		}

		catch (Exception oops) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;
	}

}
