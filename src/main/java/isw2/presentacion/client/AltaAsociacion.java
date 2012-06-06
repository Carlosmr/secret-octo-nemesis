package isw2.presentacion.client;

import java.util.Set;

import com.google.gwt.user.client.rpc.RemoteService;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;

public interface AltaAsociacion  extends RemoteService{

	Set<Tecnico> listarTecnicosRegistrados();

	void seleccionarTecnico(String user);

	Set<Procedimiento> listarProcedimientosNoAsociadosAlTecnico();

	void asignarProcedimientos(Set<String> idProcedimientos);

}
