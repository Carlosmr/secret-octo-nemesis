package isw2.presentacion.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AltaTecnicoAsync {

	void registrarTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono,
			AsyncCallback<Boolean> callback);

}
