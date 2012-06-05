package isw2.repositorios.persistencia;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.entidades.implementaciones.TecnicoImpl;
import isw2.repositorios.RepositorioProcedimientos;

public class RepositorioProcedimientosImpl extends RepositorioJPA implements
		RepositorioProcedimientos {

	public RepositorioProcedimientosImpl() {
	}

	public Procedimiento crearProcedimiento(String codigo, String nombre,
			String descripcion) {
		return new ProcedimientoImpl(codigo, nombre, descripcion);

	}

	public Set<Procedimiento> getProcedimientos() {

		EntityManager em = getEntityManager();
		Set<Procedimiento> result = new HashSet<Procedimiento>();

		try {

			em.getTransaction().begin();
			Collection<ProcedimientoImpl> clientRepository = em.createQuery(
					"from ProcedimientoImpl", ProcedimientoImpl.class)
					.getResultList();
			System.out.println(clientRepository.size());
			result = new HashSet<Procedimiento>(clientRepository);
			em.getTransaction().commit();

		} catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;
	}

	public Set<Procedimiento> getProcedimientosDadosDeAlta() {
		EntityManager em = getEntityManager();

		Set<Procedimiento> result = new HashSet<Procedimiento>();

		try {

			em.getTransaction().begin();
			Collection<ProcedimientoImpl> clientRepository = em
					.createQuery(
							"SELECT pr FROM ProcedimientoImpl pr WHERE pr.dadoDeBaja = false",
							ProcedimientoImpl.class).getResultList();

			result = new HashSet<Procedimiento>(clientRepository);
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

	public void guardar(Procedimiento procedimiento) {
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			em.persist(procedimiento);
			em.getTransaction().commit();

		}

		catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public Procedimiento getProcedimiento(String codigo) {

		Procedimiento result = new ProcedimientoImpl();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			result = em.find(ProcedimientoImpl.class, codigo);
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

	public Set<Procedimiento> getProcedimientosNoAsociadosAlTecnico(String user) {

		Set<Procedimiento> result = new HashSet<Procedimiento>();
		EntityManager em = getEntityManager();

		try {

			em.getTransaction().begin();
			Set<Procedimiento> procedimientosUsuario = em.find(
					TecnicoImpl.class, user).getProcedimientos();
			Set<Procedimiento> procedimientos = new HashSet<Procedimiento>(em
					.createQuery("from ProcedimientoImpl",
							ProcedimientoImpl.class).getResultList());
			procedimientos.removeAll(procedimientosUsuario);
			result = procedimientos;

			em.getTransaction().commit();

		} catch (Exception oops) {

			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;
	}

}
