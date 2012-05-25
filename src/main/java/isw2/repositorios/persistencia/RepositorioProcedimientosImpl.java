package isw2.repositorios.persistencia;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.repositorios.RepositorioProcedimientos;

public class RepositorioProcedimientosImpl extends RepositorioJPA implements
		RepositorioProcedimientos {

	public RepositorioProcedimientosImpl(EntityManager em) {
		super(em);
	}

	public Procedimiento crearProcedimiento(String codigo, String nombre,
			String descripcion) {

		Procedimiento result = new ProcedimientoImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = new ProcedimientoImpl(codigo, nombre, descripcion);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

	public Set<Procedimiento> getProcedimientos() {

		Set<Procedimiento> result = new HashSet<Procedimiento>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<ProcedimientoImpl> clientRepository = getEntityManager()
					.createQuery("from ProcedimientoImpl", ProcedimientoImpl.class)
					.getResultList();
			System.out.println(clientRepository.size());
			result = new HashSet<Procedimiento>(clientRepository);
			getEntityManager().getTransaction().commit();

		} catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

	public Set<Procedimiento> getProcedimientosDadosDeAlta() {

		Set<Procedimiento> result = new HashSet<Procedimiento>();

		try {

			getEntityManager().getTransaction().begin();
			Collection<Procedimiento> clientRepository = getEntityManager()
					.createQuery(
							"SELECT pr FROM Procedimiento pr WHERE pr.dadoDeBaja = false",
							Procedimiento.class).getResultList();

			result = new HashSet<Procedimiento>(clientRepository);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {
			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public void guardar(Procedimiento procedimiento) {

		try {

			getEntityManager().getTransaction().begin();
			getEntityManager().persist(procedimiento);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

	}

	public Procedimiento getProcedimiento(String codigo) {

		Procedimiento result = new ProcedimientoImpl();

		try {

			getEntityManager().getTransaction().begin();
			result = getEntityManager().find(ProcedimientoImpl.class, codigo);
			getEntityManager().getTransaction().commit();

		}

		catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;

	}

	public Set<Procedimiento> getProcedimientosNoAsociadosAlTecnico(String user) {

		Set<Procedimiento> result = new HashSet<Procedimiento>();

		try {

			getEntityManager().getTransaction().begin();
			Set<Procedimiento> procedimientosUsuario = getEntityManager().find(
					Tecnico.class, user).getProcedimientos();
			Set<Procedimiento> procedimientos = new HashSet<Procedimiento>(
					getEntityManager().createQuery("from Procedimiento",
							Procedimiento.class).getResultList());
			procedimientos.removeAll(procedimientosUsuario);
			result = procedimientos;

			getEntityManager().getTransaction().commit();

		} catch (Exception oops) {

			if (getEntityManager().getTransaction().isActive())
				getEntityManager().getTransaction().rollback();
		}

		return result;
	}

}
