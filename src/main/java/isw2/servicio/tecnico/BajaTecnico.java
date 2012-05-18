package isw2.servicio.tecnico;

import java.util.Set;

import isw2.entidades.contratos.Tecnico;

public interface BajaTecnico {

	Set<Tecnico> listarTecnicos();
	
	void darDeBajaTecnico(String user);
	
}
