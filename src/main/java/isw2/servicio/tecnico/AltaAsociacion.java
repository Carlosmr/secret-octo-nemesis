package isw2.servicio.tecnico;

import java.util.Set;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;

@RemoteServiceRelativePath("altaasociacion")
public interface AltaAsociacion extends RemoteService {

	Set<Tecnico> listarTecnicosRegistrados();

	void seleccionarTecnico(String user);

	Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico();

	void asignarProcedimientos(Set<String> idProcedimientos);

}
