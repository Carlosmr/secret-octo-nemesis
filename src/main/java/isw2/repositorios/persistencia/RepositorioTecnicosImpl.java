package isw2.repositorios.persistencia;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioTecnicos;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

public class RepositorioTecnicosImpl extends RepositorioJPA implements
		RepositorioTecnicos {

	public RepositorioTecnicosImpl(EntityManager em) {
		super(em);
	}

	public Boolean credencialesValidos(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isTecnicoLogged() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tecnico crearTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono) {
		// TODO Auto-generated method stub
		return null;
	}

	public void logIn(String user, String password) {
		// TODO Auto-generated method stub

	}

	public Set<Tecnico> getTecnicos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void guardar(Tecnico tecnico) {
		// TODO Auto-generated method stub

	}

	public Tecnico getTecnico(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
