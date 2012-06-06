package isw2.presentacion.client;

import java.util.Set;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import isw2.presentacion.shared.Procedimiento;
import isw2.presentacion.shared.Tecnico;

@RemoteServiceRelativePath("altaasociacion")
public interface AltaAsociacion extends RemoteService {

	Set<Tecnico> listarTecnicosRegistrados();

	void seleccionarTecnico(String user);

	Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico();

	void asignarProcedimientos(Set<String> idProcedimientos);

}
