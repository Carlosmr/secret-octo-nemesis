package isw2.servicio.tecnico;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

public class ModificacionTecnicoImpl implements ModificacionTecnico {

	private RepositorioTecnicos rt;
	private Tecnico t;

	public ModificacionTecnicoImpl() {

		EntityManager em = SingleEntityManager.getEntityManager();
		rt = new RepositorioTecnicosImpl(em);
	}

	public Set<Tecnico> listarTecnicos() {

		return rt.getTecnicos();
	}

	public Tecnico seleccionaTecnico(String user) {

		t = rt.getTecnico(user);
		return t;
	}

	public void guardarDatosPersonales(String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String telefono) {

		t.setNombre(nombre);
		t.setApellidos(apellidos);
		t.setFechaNacimiento(fechaNacimiento);
		t.setDireccion(direccion);
		t.setTelefono(telefono);

	}

	public void guardarCredenciales(String password) {

		t.setPassword(password);

	}

}
