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

	public RepositorioTecnicosImpl(EntityManager em) {
		super(em);
		if (getEntityManager().find(TecnicoImpl.class, "SYSTEM") == null) {
			Tecnico t = new TecnicoImpl("SYSTEM", "", "SYSTEM", "SYSTEM",
					new Date(), "", "");
			em.persist(t);
		}
	}

	public Boolean credencialesValidos(String user, String password) {

		Boolean result = false;

		try {
			getEntityManager().getTransaction().begin();
			result = getEntityManager()
					.createQuery(
							"SELECT t FROM Tecnico t WHERE t.user = :user AND t.password = :password",
							TecnicoImpl.class).setParameter("user", user)
					.setParameter("password", password).getResultList().size() > 0;
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {
			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}


		return result;
	}

	public Boolean isTecnicoLogged() {
		// TODO Completar el LogIn usuario
		return null;
	}

	public Tecnico crearTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono) {

		Tecnico result = new TecnicoImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = new TecnicoImpl(user, password, nombre, apellidos,
					fechaNac, direccion, telefono);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}


		return result;

	}

	public void logIn(String user, String password) {
		if (credencialesValidos(user, password)) {
			// TODO: Loguear usuario.
		}
	}

	public Set<Tecnico> getTecnicos() {

		Set<Tecnico> result = new HashSet<Tecnico>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Tecnico> clientRepository = getEntityManager()
					.createQuery("from Tecnico", Tecnico.class).getResultList();
			result = new HashSet<Tecnico>(clientRepository);
			getEntityManager().getTransaction().commit();

		} catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}


		return result;

	}

	public Set<Tecnico> getTecnicosDadosDeAlta() {

		Set<Tecnico> result = new HashSet<Tecnico>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Tecnico> clientRepository = getEntityManager()
					.createQuery(
							"SELECT t FROM Tecnico t WHERE t.dadoDeBaja = false",
							Tecnico.class).getResultList();

			result = new HashSet<Tecnico>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {
			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}


		return result;

	}

	public void guardar(Tecnico tecnico) {

		try {

			getEntityManager().getTransaction().begin();
			getEntityManager().persist(tecnico);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

	}

	public Tecnico getTecnico(String user) {

		Tecnico result = new TecnicoImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = getEntityManager().find(Tecnico.class, user);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

}
