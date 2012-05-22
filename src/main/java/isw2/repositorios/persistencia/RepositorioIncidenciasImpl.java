package isw2.repositorios.persistencia;

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
		return new HashSet<Incidencia>(getEntityManager()
				.createQuery("SELECT i FROM Incidencia i WHERE i.dni = :dni",
						Incidencia.class).setParameter("dni", dni)
				.getResultList());
	}

	public Set<Incidencia> buscarIncidencia(String busqueda) {
		return new HashSet<Incidencia>(
				getEntityManager()
						.createQuery(
								"SELECT i FROM Incidencia i WHERE i.nombre LIKE %:busqueda% OR i.email LIKE %:busqueda% OR i.descripcion LIKE %:busqueda%",
								Incidencia.class)
						.setParameter("busqueda", busqueda).getResultList());
	}

	public Incidencia crearIncidencia(String nombreCliente, String dni,
			String email, String descripcion, Date fechaCompra) {
		return new IncidenciaImpl(nombreCliente, dni, email, descripcion,
				fechaCompra);
	}

	public Set<Incidencia> getIncidencias() {
		return new HashSet<Incidencia>(getEntityManager().createQuery(
				"from Incidencia", Incidencia.class).getResultList());
	}

	public void guardar(Incidencia incidencia) {
		getEntityManager().persist(incidencia);
	}

	public Incidencia getIncidencia(Integer id) {
		return getEntityManager().find(Incidencia.class, id);
	}

	public Set<Incidencia> getIncidencias(String user) {

		return new HashSet<Incidencia>(getEntityManager()
				.createQuery(
						"SELECT i FROM Incidencia i WHERE i.tecnico = :user",
						Incidencia.class).setParameter("user", user)
				.getResultList());
	}

	public Set<Incidencia> getIncidenciasSinRespuesta(String user) {
		return new HashSet<Incidencia>(
				getEntityManager()
						.createQuery(
								"SELECT i FROM Incidencia i WHERE i.respuesta = :respuesta AND i.tecnico = :user",
								Incidencia.class)
						.setParameter("respuesta", null)
						.setParameter("tecnico", user).getResultList());
	}

	public Set<Incidencia> getIncidenciasSinAsignar() {
		return new HashSet<Incidencia>(getEntityManager()
				.createQuery(
						"SELECT i FROM Incidencia i WHERE i.tecnico = :user",
						Incidencia.class).setParameter("user", null)
				.getResultList());
	}
}
