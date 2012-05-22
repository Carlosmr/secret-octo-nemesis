package isw2.repositorios.persistencia;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.entidades.contratos.Procedimiento;
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

	public void guardar(Procedimiento procedimiento) {
		getEntityManager().persist(procedimiento);
	}

	public Procedimiento getProcedimiento(String codigo) {
		return getEntityManager().find(Procedimiento.class, codigo);
	}

	public Set<Procedimiento> getProcedimientosNoAsociadosAlTecnico(String user) {

		return new HashSet<Procedimiento>(getEntityManager().createQuery(
				//TODO revisar esta consulta porque tiene pinta de que esté mal
				"SELECT * FROM Procedimiento WHERE NOT tecnico = :user",
				Procedimiento.class).getResultList());
	}

}
