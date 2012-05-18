package isw2.servicio.tecnico;

import java.util.Date;
import java.util.Set;

import isw2.entidades.contratos.Tecnico;

public interface ModificacionTecnico {

	Set<Tecnico> listarTecnicos();
	
	Tecnico seleccionaTecnico(String user);
	
	void guardarDatosPersonales(String nombre,
			String apellidos, Date fechaNacimiento, String direccion,
			String telefono);
	
	void guardarCredenciales(String password);

}
