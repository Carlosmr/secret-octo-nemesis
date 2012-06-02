package isw2.pruebas;

import isw2.repositorios.RepositorioIncidencias;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.SingleEntityManager;
import isw2.servicio.incidencia.AltaIncidencia;
import isw2.servicio.incidencia.AltaIncidenciaImpl;
import isw2.servicio.incidencia.AsignarIncidencia;
import isw2.servicio.incidencia.AsignarIncidenciaImpl;
import isw2.servicio.incidencia.ResponderIncidencia;
import isw2.servicio.incidencia.ResponderIncidenciaImpl;
import isw2.servicio.procedimiento.AltaProcedimiento;
import isw2.servicio.procedimiento.AltaProcedimientoImpl;
import isw2.servicio.producto.AltaProducto;
import isw2.servicio.producto.AltaProductoImpl;
import isw2.servicio.tecnico.AltaAsociacion;
import isw2.servicio.tecnico.AltaAsociacionImpl;
import isw2.servicio.tecnico.AltaTecnico;
import isw2.servicio.tecnico.AltaTecnicoImpl;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

public class EntryPoint {

	public static void main(String[] args) {

		EntityManager em = SingleEntityManager.getEntityManager();
		RepositorioIncidencias ri = new RepositorioIncidenciasImpl(em);
		AltaTecnico a1 = new AltaTecnicoImpl();
		a1.introducirCredenciales("benito", "benito");
		a1.introducirDatosPersonales("benito", "benito", new Date(), "a", "9");
		a1.registrarTecnico();

		AltaTecnico a2 = new AltaTecnicoImpl();
		a2.introducirCredenciales("currito", "currito");
		a2.introducirDatosPersonales("curro", "herrera", new Date(),
				"guadalquivir n� 25", "955552321");
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

		AltaAsociacion as = new AltaAsociacionImpl();
		as.seleccionarTecnico("benito");
		Set<String> idProcedimientos = new HashSet<String>();
		idProcedimientos.add("p0000");
		as.asignarProcedimientos(idProcedimientos);

		AltaIncidencia i1 = new AltaIncidenciaImpl();
		i1.introducirDescripcionIncidencia("rotura de la base de la pantalla");
		i1.seleccionarIncidenciasUsuario("javier", "53354148",
				"javhercop@gmail.com", new Date());
		i1.seleccionarProcedimiento("p0000");
		i1.seleccionarProducto("0000");
		i1.registrarIncidencia();

		AltaIncidencia i2 = new AltaIncidenciaImpl();
		i2.introducirDescripcionIncidencia("rotura de la base de la pantalla");
		i2.seleccionarIncidenciasUsuario("javier", "53354148",
				"javhercop@gmail.com", new Date());
		i2.seleccionarProcedimiento("p0000");
		i2.seleccionarProducto("0000");
		i2.registrarIncidencia();

		AsignarIncidencia asigna = new AsignarIncidenciaImpl();
		asigna.listarIncidenciasSinAsignar("benito");
		Set<Integer> incidencias = new HashSet<Integer>();
		incidencias.add(1);
		incidencias.add(2);
		asigna.asociarIncidencia(incidencias);

		//
		// ResponderIncidencia res = new ResponderIncidenciaImpl();
		// res.seleccionarIncidencia(1);
		// res.anadirDescripcion("Reparacion finalizada.");
		// res.registrarRespuesta();

		ResponderIncidencia res2 = new ResponderIncidenciaImpl();
		res2.seleccionarIncidencia(2);
		res2.anadirDescripcion("Reparacion finalizada.");
		res2.registrarRespuesta();

		// ValorarIncidencia val = new ValorarIncidenciaImpl();
		// val.registrarValoracion(1, 1);

		System.out.println("Incidencias del sistema " + ri.getIncidencias());
		System.out.println("Tecnico asociado a la incidencia numero 1 "
				+ ri.getIncidencia(1).getTecnico());
		System.out.println("Incidencias sin asingar "
				+ ri.getIncidenciasSinAsignar());
		System.out.println("Incidencias de un usuario dado "
				+ ri.getIncidencias("benito"));
		System.out.println("Buscar incidencia por dni "
				+ ri.buscarIncidenciasPorDni("53354148"));
		System.out.println("Incidencas sin respuesta "
				+ ri.getIncidenciasSinRespuesta("benito"));
		System.out.println("Respuesta a la incidencia "
				+ ri.getIncidencia(1).getRespuesta());
		// System.out.println("Valoracion de larespuesta a la incidencia "
		// + ri.getIncidencia(1).getRespuesta().getValoracion());

	}
}
