package isw2.presentacion.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface RegistroTecnicoService extends RemoteService {

	Boolean registrar(String user, String password);
}
