package isw2.repositorios.persistencia;

import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.TecnicoImpl;
import isw2.repositorios.RepositorioTecnicos;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class RepositorioTecnicosImpl extends RepositorioJPA implements
		RepositorioTecnicos {

	public RepositorioTecnicosImpl() {
		super();
		if (getEntityManager().find(TecnicoImpl.class, "SYSTEM") == null) {
			Tecnico t = new TecnicoImpl("SYSTEM", "", "SYSTEM", "SYSTEM",
					new Date(), "", "");
			getEntityManager().persist(t);
		}
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

	public Set<Tecnico> getTecnicos() {

		Set<Tecnico> result = new HashSet<Tecnico>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<TecnicoImpl> clientRepository = getEntityManager()
					.createQuery("from TecnicoImpl", TecnicoImpl.class)
					.getResultList();
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
			Collection<TecnicoImpl> clientRepository = getEntityManager()
					.createQuery(
							"SELECT t FROM TecnicoImpl t WHERE t.dadoDeBaja = false",
							TecnicoImpl.class).getResultList();

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
			result = getEntityManager().find(TecnicoImpl.class, user);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

}