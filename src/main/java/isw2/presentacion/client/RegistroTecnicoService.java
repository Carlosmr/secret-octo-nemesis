package isw2.presentacion.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registroTecnico")
public interface RegistroTecnicoService extends RemoteService {

	Boolean registrar(String user, String password);
}

