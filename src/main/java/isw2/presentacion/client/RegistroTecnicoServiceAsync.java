package isw2.presentacion.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistroTecnicoServiceAsync {

	void registrar(String user, String password, AsyncCallback<Boolean> callback);
}
