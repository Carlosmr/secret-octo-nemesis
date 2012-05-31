package isw2.autentificacion;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import javax.persistence.EntityManager;

public class AutentificacionJPA implements Autentificacion {

	
	private RepositorioTecnicosImpl rt;


	public AutentificacionJPA(){
		EntityManager em = SingleEntityManager.getEntityManager();
		this.rt = new RepositorioTecnicosImpl(em);
	}
	
	
	public Boolean credencialesValidos(String user, String password) {
		Tecnico t = rt.getTecnico(user);
		if(t!=null)
			return t.getPassword().equals(password);
		else
			return false;
	}

}
