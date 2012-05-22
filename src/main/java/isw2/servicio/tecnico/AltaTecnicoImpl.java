package isw2.servicio.tecnico;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Date;

import javax.persistence.EntityManager;

public class AltaTecnicoImpl implements AltaTecnico {

	private RepositorioTecnicos rt;
	private Tecnico t;
	private String user;
	private String password;

	public AltaTecnicoImpl() {

		EntityManager em = SingleEntityManager.getEntityManager();
		rt = new RepositorioTecnicosImpl(em);

	}

	public void introducirDatosPersonales(String nombre, String apellidos,
			Date fechaNac, String direccion, String telefono) {
		t = rt.crearTecnico(user, password, nombre, apellidos, fechaNac,
				direccion, telefono);

	}

	public void introducirCredenciales(String user, String password) {

		if (rt.getTecnico(user) == null) {
			// no existe ese tecnico
			this.user = user;
			this.password = password;
		} else {

			System.err.print("El técnico con user " + user + " ya existe.");
		}

	}

	public void registrarTecnico() {
		rt.guardar(t);

	}
}
