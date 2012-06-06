package isw2.presentacion.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("altatecnico")
public interface AltaTecnico extends RemoteService{
	
	void introducirDatosPersonales(String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono);
	
	void introducirCredenciales(String user, String password);
	
	void registrarTecnico();
	
	
}
