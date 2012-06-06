package isw2.presentacion.client;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;

import java.util.Set;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AltaAsociacionAsync {

	void asignarProcedimientos(Set<String> idProcedimientos,
			AsyncCallback<Void> callback);

	void listarProcedimientosNoAsociadosAlTecnico(
			AsyncCallback<Set<Procedimiento>> callback);

	void listarTecnicosRegistrados(AsyncCallback<Set<Tecnico>> callback);

	void seleccionarTecnico(String user, AsyncCallback<Void> callback);

}
