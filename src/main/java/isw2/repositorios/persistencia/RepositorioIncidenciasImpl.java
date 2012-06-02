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

	public RepositorioIncidenciasImpl(EntityManager em) {
		super(em);
	}

	public Set<Incidencia> buscarIncidenciasPorDni(String dni) {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {
			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM IncidenciaImpl i WHERE i.dni = :dni",
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
			Collection<IncidenciaImpl> clientRepository = getEntityManager()
					.createQuery(
							"SELECT t FROM IncidenciaImpl t WHERE t.email LIKE :busqueda OR t.descripcion LIKE :busqueda OR t.nombre LIKE :busqueda",
							IncidenciaImpl.class)
					.setParameter("busqueda", "%" + busqueda + "%")
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

	public Incidencia crearIncidencia(String nombreCliente, String dni,
			String email, String descripcion, Date fechaCompra) {

		return new IncidenciaImpl(nombreCliente, dni, email, descripcion,
				fechaCompra);
	}

	public Set<Incidencia> getIncidencias() {

		Set<Incidencia> result = new HashSet<Incidencia>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Incidencia> clientRepository = getEntityManager()
					.createQuery("from IncidenciaImpl", Incidencia.class)
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
			Collection<IncidenciaImpl> clientRepository = getEntityManager()
					.createQuery(
							"SELECT i FROM IncidenciaImpl i",
							IncidenciaImpl.class)
					.getResultList();
			for (Incidencia i : clientRepository) {
				if (i.getTecnico().getUser().equals(user))
					result.add(i);

			}

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
							"SELECT i FROM IncidenciaImpl i WHERE i.respuesta = NULL ",
							Incidencia.class).getResultList();
			for (Incidencia i : clientRepository) {
				if (i.getTecnico().getUser().equals(user))
					result.add(i);

			}

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
							"SELECT i FROM IncidenciaImpl i WHERE i.tecnico = NULL ",
							Incidencia.class).getResultList();
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
