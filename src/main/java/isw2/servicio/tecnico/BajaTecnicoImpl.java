package isw2.servicio.tecnico;

import isw2.entidades.contratos.Tecnico;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;

import java.util.Set;


public class BajaTecnicoImpl implements BajaTecnico {

	private RepositorioTecnicos rt;
	private Tecnico t;

	public BajaTecnicoImpl() {

		rt = new RepositorioTecnicosImpl();

	}

	public Set<Tecnico> listarTecnicosActivos() {

		return rt.getTecnicosDadosDeAlta();
	}

	public Set<Tecnico> listarTecnicos() {

		return rt.getTecnicos();
	}

	public void darDeBajaTecnico(String user) {

		t = rt.getTecnico(user);
		t.setDadoDeBaja(true);

	}

}
