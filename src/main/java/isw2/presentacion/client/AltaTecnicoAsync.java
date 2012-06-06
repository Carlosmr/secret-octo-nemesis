package isw2.presentacion.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AltaTecnicoAsync {

	void introducirCredenciales(String user, String password,
			AsyncCallback<Void> callback);

	void introducirDatosPersonales(String nombre, String apellidos,
			Date fechaNac, String direccion, String telefono,
			AsyncCallback<Void> callback);

	void registrarTecnico(AsyncCallback<Void> callback);

}
