package isw2.servicio.tecnico;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import java.util.Set;

public class BajaAsociacionImpl implements BajaAsociacion {

	private RepositorioTecnicos rt;
	private Tecnico t;

	public BajaAsociacionImpl() {


		rt = new RepositorioTecnicosImpl();

	}

	public Set<Tecnico> listarTecnicosActivos() {

		return rt.getTecnicosDadosDeAlta();
	}

	public Set<Tecnico> listarTecnicos() {

		return rt.getTecnicos();
	}

	public void seleccionaTecnico(String user) {

		this.t = rt.getTecnico(user);
	}

	public Set<Procedimiento> listarProcedimientos() {

		return t.getProcedimientos();
	}

	public void desasociarProcedimientos(Set<Procedimiento> procedimientos) {

		for (Procedimiento p : procedimientos) {
			t.eliminaProcedimiento(p);
		}

	}

}
