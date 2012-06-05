package isw2.repositorios.persistencia;

import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.TecnicoImpl;
import isw2.repositorios.RepositorioTecnicos;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

public class RepositorioTecnicosImpl extends RepositorioJPA implements
		RepositorioTecnicos {

	public RepositorioTecnicosImpl() {
		EntityManager em = getEntityManager();
		if (em.find(TecnicoImpl.class, "SYSTEM") == null) {
			Tecnico t = new TecnicoImpl("SYSTEM", "", "SYSTEM", "SYSTEM",
					new Date(), "", "");
			em.persist(t);
		}
	}

	public Tecnico crearTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono) {
		return new TecnicoImpl(user, password, nombre, apellidos, fechaNac,
				direccion, telefono);

	}

	public Set<Tecnico> getTecnicos() {

		Set<Tecnico> result = new HashSet<Tecnico>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Collection<TecnicoImpl> clientRepository = em.createQuery(
					"from TecnicoImpl", TecnicoImpl.class).getResultList();
			result = new HashSet<Tecnico>(clientRepository);
			em.getTransaction().commit();

		} catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;

	}

	public Set<Tecnico> getTecnicosDadosDeAlta() {

		Set<Tecnico> result = new HashSet<Tecnico>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Collection<TecnicoImpl> clientRepository = em.createQuery(
					"SELECT t FROM TecnicoImpl t WHERE t.dadoDeBaja = false",
					TecnicoImpl.class).getResultList();

			result = new HashSet<Tecnico>(clientRepository);
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

	public void guardar(Tecnico tecnico) {
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			em.persist(tecnico);
			em.getTransaction().commit();

		}

		catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Tecnico getTecnico(String user) {
		EntityManager em = getEntityManager();

		Tecnico result = new TecnicoImpl();

		try {

			em.getTransaction().begin();
			result = em.find(TecnicoImpl.class, user);
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
