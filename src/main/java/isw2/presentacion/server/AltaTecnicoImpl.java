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
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private String direccion;
	private String telefono;

	public AltaTecnicoImpl() {

		rt = new RepositorioTecnicosImpl();

	}

	public void introducirDatosPersonales(String nombre, String apellidos,
			Date fechaNac, String direccion, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public void introducirCredenciales(String user, String password) {

		this.user = user;
		this.password = password;

	}

	public void registrarTecnico() {
		rt.guardar(rt.crearTecnico(user, password, nombre, apellidos, fechaNac,
				direccion, telefono));

	}
}
