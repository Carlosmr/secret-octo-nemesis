package isw2.presentacion.server;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import isw2.entidades.contratos.Tecnico;
import isw2.presentacion.client.RegistroTecnicoService;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

public class RegistroTecnicoServiceImpl extends RemoteServiceServlet implements
		RegistroTecnicoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6487609953566342063L;

	public Boolean registrar(String user, String password) {
		RepositorioTecnicos rt = new RepositorioTecnicosImpl();
		Boolean res = false;
		if(rt.getTecnico(user)==null)
			res = true;
		Tecnico t = rt.crearTecnico(user, password, user, user, new Date(),
				"calle falsa, 123", "213132123");
		rt.guardar(t);
		return res;
	}

}
