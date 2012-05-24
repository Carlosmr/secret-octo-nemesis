package isw2.repositorios.persistencia;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.implementaciones.IncidenciaImpl;
import isw2.repositorios.RepositorioIncidencias;

//TODO revisar al menos esta clase sus transacciones para ver si son correctas o no, las dem�s siguen la misma estructura.

public class RepositorioIncidenciasImpl extends RepositorioJPA implements
		RepositorioIncidencias {

	public RepositorioIncidenciasImpl(EntityManager em) {
		super(em);
	}

	public Set<Incidencia> buscarIncidenciasPorDni(String dni) {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {
			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM Incidencia i WHERE i.dni = :dni",
							Incidencia.class).setParameter("dni", dni)
					.getResultList();

			result = new HashSet<Incidencia>(clientRepository);
			getEntityManager().getTransaction().commit();
		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public Set<Incidencia> buscarIncidencia(String busqueda) {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM Incidencia i WHERE i.nombre LIKE %:busqueda% OR i.email LIKE %:busqueda% OR i.descripcion LIKE %:busqueda%",
							Incidencia.class)
					.setParameter("busqueda", busqueda).getResultList();
			result = new HashSet<Incidencia>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

	public Incidencia crearIncidencia(String nombreCliente, String dni,
			String email, String descripcion, Date fechaCompra) {

		Incidencia result = new IncidenciaImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = new IncidenciaImpl(nombreCliente, dni, email, descripcion,
					fechaCompra);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

	public Set<Incidencia> getIncidencias() {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery("from Incidencia", Incidencia.class)
					.getResultList();
			result = new HashSet<Incidencia>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

	public void guardar(Incidencia incidencia) {

		try {

			getEntityManager().getTransaction().begin();
			getEntityManager().persist(incidencia);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

	}

	public Incidencia getIncidencia(Integer id) {

		Incidencia result = new IncidenciaImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = getEntityManager().find(IncidenciaImpl.class, id);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

	public Set<Incidencia> getIncidencias(String user) {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM Incidencia i WHERE i.tecnico = :user",
							Incidencia.class).setParameter("user", user)
					.getResultList();
			result = new HashSet<Incidencia>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public Set<Incidencia> getIncidenciasSinRespuesta(String user) {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM Incidencia i WHERE i.respuesta = :respuesta AND i.tecnico = :user",
							Incidencia.class).setParameter("respuesta", null)
					.setParameter("tecnico", user).getResultList();
			result = new HashSet<Incidencia>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public Set<Incidencia> getIncidenciasSinAsignar() {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {
			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM Incidencia i WHERE i.tecnico = :user",
							Incidencia.class).setParameter("user", null)
					.getResultList();
			result = new HashSet<Incidencia>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}
}
