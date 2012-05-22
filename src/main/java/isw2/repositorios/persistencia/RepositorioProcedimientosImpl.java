package isw2.repositorios.persistencia;

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
		return new ProcedimientoImpl(codigo, nombre, descripcion);
	}

	public Set<Procedimiento> getProcedimientos() {
		return new HashSet<Procedimiento>(getEntityManager().createQuery(
				"from Procedimiento", Procedimiento.class).getResultList());
	}

	public Set<Procedimiento> getProcedimientosDadosDeAlta() {

		return new HashSet<Procedimiento>(getEntityManager().createQuery(
				"SELECT pr FROM Procedimiento pr WHERE pr.dadoDeBaja = false",
				Procedimiento.class).getResultList());
	}

	public void guardar(Procedimiento procedimiento) {
		getEntityManager().persist(procedimiento);
	}

	public Procedimiento getProcedimiento(String codigo) {
		return getEntityManager().find(Procedimiento.class, codigo);
	}

	public Set<Procedimiento> getProcedimientosNoAsociadosAlTecnico(String user) {
		Set<Procedimiento> procedimientosUsuario = getEntityManager().find(
				Tecnico.class, user).getProcedimientos();
		Set<Procedimiento> procedimientos = new HashSet<Procedimiento>(
				getEntityManager().createQuery("from Procedimiento",
						Procedimiento.class).getResultList());
		procedimientos.removeAll(procedimientosUsuario);
		return procedimientos;

	}
}
