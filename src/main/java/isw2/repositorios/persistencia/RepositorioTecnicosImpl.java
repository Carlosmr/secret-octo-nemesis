package isw2.repositorios.persistencia;

import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.TecnicoImpl;
import isw2.repositorios.RepositorioTecnicos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

public class RepositorioTecnicosImpl extends RepositorioJPA implements
		RepositorioTecnicos {

	public RepositorioTecnicosImpl(EntityManager em) {
		super(em);
	}

	public Boolean credencialesValidos(String user, String password) {
		return getEntityManager()
				.createQuery(
						"SELECT t FROM Tecnico t WHERE t.user = :user AND t.password = :password",
						Tecnico.class).setParameter("user", user)
				.setParameter("password", password).getResultList().size() > 0;
	}

	public Boolean isTecnicoLogged() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tecnico crearTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono) {
		return new TecnicoImpl(user, password, nombre, apellidos, fechaNac,
				direccion, telefono);
	}

	public void logIn(String user, String password) {
		if (credencialesValidos(user, password)) {
			// TODO: Loguear usuario.
		}
	}

	public Set<Tecnico> getTecnicos() {
		return new HashSet<Tecnico>(getEntityManager().createQuery(
				"from Tecnico", Tecnico.class).getResultList());
	}

	public Set<Tecnico> getTecnicosActivos() {

		return new HashSet<Tecnico>(getEntityManager().createQuery(
				"SELECT t FROM Tecnico WHERE t.dadoDeBaja = false",
				Tecnico.class).getResultList());
	}

	public void guardar(Tecnico tecnico) {
		getEntityManager().persist(tecnico);
	}

	public Tecnico getTecnico(String user) {
		return getEntityManager().find(Tecnico.class, user);
	}

}
