package isw2.pruebas;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.IncidenciaImpl;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.repositorios.RepositorioIncidencias;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioProductos;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.RepositorioJPA;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioProductosImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;
import isw2.servicio.incidencia.AltaIncidencia;
import isw2.servicio.incidencia.AltaIncidenciaImpl;
import isw2.servicio.incidencia.AsignarIncidencia;
import isw2.servicio.incidencia.AsignarIncidenciaImpl;
import isw2.servicio.procedimiento.AltaProcedimiento;
import isw2.servicio.procedimiento.AltaProcedimientoImpl;
import isw2.servicio.producto.AltaProducto;
import isw2.servicio.producto.AltaProductoImpl;
import isw2.servicio.producto.ModificacionProducto;
import isw2.servicio.producto.ModificacionProductoImpl;
import isw2.servicio.tecnico.AltaAsociacion;
import isw2.servicio.tecnico.AltaAsociacionImpl;
import isw2.servicio.tecnico.AltaTecnico;
import isw2.servicio.tecnico.AltaTecnicoImpl;
import isw2.servicio.tecnico.BajaAsociacion;
import isw2.servicio.tecnico.BajaAsociacionImpl;
import isw2.servicio.tecnico.ModificacionTecnico;
import isw2.servicio.tecnico.ModificacionTecnicoImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

public class EntryPoint {

	public static void main(String[] args) {

		EntityManager em = SingleEntityManager.getEntityManager();
		RepositorioIncidencias ri = new RepositorioIncidenciasImpl(em);
		RepositorioProcedimientos rproc = new RepositorioProcedimientosImpl(em);
		RepositorioProductos rp = new RepositorioProductosImpl(em);
		RepositorioTecnicos rt = new RepositorioTecnicosImpl(em);

		AltaTecnico a1 = new AltaTecnicoImpl();
		a1.introducirCredenciales("benito", "benito");
		a1.introducirDatosPersonales("benito", "benito", new Date(), "a", "9");
		a1.registrarTecnico();
		AltaTecnico a2 = new AltaTecnicoImpl();
		a2.introducirCredenciales("currito", "currito");
		a2.introducirDatosPersonales("curro", "herrera", new Date(),
				"guadalquivir nº 25", "955552321");
		a2.registrarTecnico();

		AltaProcedimiento altaP1 = new AltaProcedimientoImpl();
		altaP1.introducirDatosProcedimiento("p0000", "rotura pantalla",
				"rotura pantalla");

		AltaProducto alta1 = new AltaProductoImpl();
		alta1.datosProducto("0000", "televisor", "televisor");
		Set<String> setProcedimientos = new HashSet<String>();
		setProcedimientos.add("p0000");
		alta1.seleccionarProcedimientos(setProcedimientos);
		alta1.registrarProducto();

		AltaIncidencia i1 = new AltaIncidenciaImpl();
		i1.introducirDescripcionIncidencia("rotura de la base de la pantalla");
		i1.seleccionarIncidenciasUsuario("javier", "53354148",
				"javhercop@gmail.com", new Date());
		i1.seleccionarProcedimiento("p0000");
		i1.seleccionarProducto("0000");
		i1.registrarIncidencia();

//		AsignarIncidencia asigna = new AsignarIncidenciaImpl();
//		asigna.seleccionarIncidencia(1);
//		asigna.asociarIncidenciaTecnico("benito");

		System.out.println("Incidencias del sistema " + ri.getIncidencias());
		System.out.println("Tecnico asociado a la incidencia numero 1 "
				+ ri.getIncidencia(1).getTecnico());
		System.out.println("Incidencias sin asingar "
				+ ri.getIncidenciasSinAsignar());
		// System.out.println("Incidencas sin respuesta "+ri.getIncidenciasSinRespuesta("benito"));

	}
}
