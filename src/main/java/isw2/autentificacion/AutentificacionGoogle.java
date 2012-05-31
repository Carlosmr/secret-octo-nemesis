package isw2.autentificacion;

import java.io.IOException;

import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.googleapis.auth.clientlogin.ClientLoginResponseException;


//TODO: No tira xD.
public class AutentificacionGoogle implements Autentificacion {

	public AutentificacionGoogle(){}
	
	
	public Boolean credencialesValidos(String user, String password) {
		ClientLogin cliente = new ClientLogin();
		cliente.username = user;
		cliente.password = password;
		try {
			cliente.authenticate();
		} catch (ClientLoginResponseException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
