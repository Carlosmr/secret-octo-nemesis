package isw2.repositorios;

import java.util.Date;
import java.util.Set;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Tecnico;

public interface RepositorioTecnicos {

	Tecnico crearTecnico(String user, String password, String nombre,
			String apellidos, Date fechaNac, String direccion, String telefono);

	Set<Tecnico> getTecnicos();

	Set<Tecnico> getTecnicosDadosDeAlta();

	void guardar(Tecnico tecnico);

	Tecnico getTecnico(String user);

}