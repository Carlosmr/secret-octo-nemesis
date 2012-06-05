package isw2.repositorios.persistencia;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.implementaciones.IncidenciaImpl;
import isw2.repositorios.RepositorioIncidencias;

public class RepositorioIncidenciasImpl extends RepositorioJPA implements
		RepositorioIncidencias {

	public RepositorioIncidenciasImpl() {
	}

	public Set<Incidencia> buscarIncidenciasPorDni(String dni) {
		EntityManager em = getEntityManager();
		Set<Incidencia> result = new HashSet<Incidencia>();
		try {
			em.getTransaction().begin();
			Collection<Incidencia> clientRepository = em
					.createQuery(
							"SELECT i FROM IncidenciaImpl i WHERE i.dni = :dni",
							Incidencia.class).setParameter("dni", dni)
					.getResultList();

			result = new HashSet<Incidencia>(clientRepository);
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

	public Set<Incidencia> buscarIncidencia(String busqueda) {

		Set<Incidencia> result = new HashSet<Incidencia>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Collection<IncidenciaImpl> clientRepository = em
					.createQuery(
							"SELECT t FROM IncidenciaImpl t WHERE t.email LIKE :busqueda OR t.descripcion LIKE :busqueda OR t.nombre LIKE :busqueda",
							IncidenciaImpl.class)
					.setParameter("busqueda", "%" + busqueda + "%")
					.getResultList();
			result = new HashSet<Incidencia>(clientRepository);
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

	public Incidencia crearIncidencia(String nombreCliente, String dni,
			String email, String descripcion, Date fechaCompra) {

		return new IncidenciaImpl(nombreCliente, dni, email, descripcion,
				fechaCompra);
	}

	public Set<Incidencia> getIncidencias() {

		Set<Incidencia> result = new HashSet<Incidencia>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Collection<Incidencia> clientRepository = em.createQuery(
					"from IncidenciaImpl", Incidencia.class).getResultList();
			result = new HashSet<Incidencia>(clientRepository);
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

	public void guardar(Incidencia incidencia) {
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			em.persist(incidencia);
			em.getTransaction().commit();

		}

		catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}

		finally {
			em.close();
		}
	}

	public Incidencia getIncidencia(Integer id) {

		Incidencia result = new IncidenciaImpl();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			result = em.find(IncidenciaImpl.class, id);
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

	public Set<Incidencia> getIncidencias(String user) {

		Set<Incidencia> result = new HashSet<Incidencia>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Collection<IncidenciaImpl> clientRepository = em.createQuery(
					"SELECT i FROM IncidenciaImpl i", IncidenciaImpl.class)
					.getResultList();
			for (Incidencia i : clientRepository) {
				if (i.getTecnico().getUser().equals(user))
					result.add(i);

			}

			result = new HashSet<Incidencia>(clientRepository);
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

	public Set<Incidencia> getIncidenciasSinRespuesta(String user) {

		Set<Incidencia> result = new HashSet<Incidencia>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Collection<Incidencia> clientRepository = em.createQuery(
					"SELECT i FROM IncidenciaImpl i WHERE i.respuesta = NULL ",
					Incidencia.class).getResultList();
			for (Incidencia i : clientRepository) {
				if (i.getTecnico().getUser().equals(user))
					result.add(i);

			}

			result = new HashSet<Incidencia>(clientRepository);
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

	public Set<Incidencia> getIncidenciasSinAsignar() {

		Set<Incidencia> result = new HashSet<Incidencia>();
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			Collection<Incidencia> clientRepository = em.createQuery(
					"SELECT i FROM IncidenciaImpl i WHERE i.tecnico = NULL ",
					Incidencia.class).getResultList();
			result = new HashSet<Incidencia>(clientRepository);
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
