package isw2.presentacion.server;

import isw2.presentacion.client.AltaTecnico;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AltaTecnicoImpl extends RemoteServiceServlet implements
		AltaTecnico {

	private static final long serialVersionUID = -4369102142516913459L;
	private RepositorioTecnicos rt;

	public AltaTecnicoImpl() {

		rt = new RepositorioTecnicosImpl();

	}

	public Boolean registrarTecnico(String user, String password,
			String nombre, String apellidos, Date fechaNac, String direccion,
			String telefono) {
		Boolean res = false;
		if (rt.getTecnico(user) == null) {
			rt.guardar(rt.crearTecnico(user, password, nombre, apellidos,
					fechaNac, direccion, telefono));
			res = true;
		}
		return res;

	}
}
