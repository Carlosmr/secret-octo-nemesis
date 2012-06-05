package isw2.autentificacion;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;


public class AutentificacionJPA implements Autentificacion {

	
	private RepositorioTecnicosImpl rt;


	public AutentificacionJPA(){
		this.rt = new RepositorioTecnicosImpl();
	}
	
	
	public Boolean credencialesValidos(String user, String password) {
		Tecnico t = rt.getTecnico(user);
		if(t!=null)
			return t.getPassword().equals(password);
		else
			return false;
	}

}
