package isw2.servicio.tecnico;

import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Date;

import javax.persistence.EntityManager;

public class AltaTecnicoImpl implements AltaTecnico {

	private RepositorioTecnicos rt;
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private String direccion;
	private String telefono;

	public AltaTecnicoImpl() {

		EntityManager em = SingleEntityManager.getEntityManager();
		rt = new RepositorioTecnicosImpl(em);

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
