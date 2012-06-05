package isw2.presentacion.server;

import java.util.Date;

import isw2.entidades.contratos.Tecnico;
import isw2.presentacion.client.RegistroTecnicoService;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

public class RegistroTecnicoServiceImpl implements RegistroTecnicoService {

	public Boolean registrar(String user, String password) {
		RepositorioTecnicos rt = new RepositorioTecnicosImpl();
		Tecnico t = rt.crearTecnico(user, password, user, user, new Date(), "calle falsa, 123", "213132123");
		rt.guardar(t);
		return rt.getTecnico(user)!=null;
	}

}
