package isw2.servicio.tecnico;

import java.util.Date;

public interface AltaTecnico {
	
	void introducirDatosPersonales(String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono);
	
	void introducirCredenciales(String user, String password);
	
	void registrarTecnico();
	
	
}
