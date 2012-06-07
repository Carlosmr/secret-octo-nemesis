package isw2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import isw2.entidades.contratos.Procedimiento;
import isw2.excepciones.InvalidStateException;
import isw2.presentacion.client.AltaTecnico;
import isw2.presentacion.server.AltaTecnicoImpl;
import isw2.servicio.incidencia.AltaIncidencia;
import isw2.servicio.incidencia.AltaIncidenciaImpl;
import isw2.servicio.incidencia.AsignarIncidencia;
import isw2.servicio.incidencia.AsignarIncidenciaImpl;
import isw2.servicio.incidencia.ResponderIncidencia;
import isw2.servicio.incidencia.ResponderIncidenciaImpl;
import isw2.servicio.incidencia.ValorarIncidencia;
import isw2.servicio.incidencia.ValorarIncidenciaImpl;
import isw2.servicio.procedimiento.AltaProcedimiento;
import isw2.servicio.procedimiento.AltaProcedimientoImpl;
import isw2.servicio.producto.AltaProducto;
import isw2.servicio.producto.AltaProductoImpl;
import isw2.servicio.tecnico.AltaAsociacion;
import isw2.servicio.tecnico.AltaAsociacionImpl;

import org.junit.Before;
import org.junit.Test;

public class Pruebas {

	@Before
	public void setup() {

	}

	@Test
	public void crearTecnico1() {
		AltaTecnico a = new AltaTecnicoImpl();
		// TODO: Cambiar estos 2 tests usando el nuevo metodo.
		a.registrarTecnico("tecnico1", "tecnico1", "tecnico1", "tecnico1",
				new Date(), "tecnico1", "955555555");

	}

	@Test
	public void crearTecnico2() {
		AltaTecnico a = new AltaTecnicoImpl();
		a.registrarTecnico("tecnico22", "tecnico2", "tecnico2", "tecnico2",
				new Date(), "tecnico2", "955555555");
	}

	@Test
	public void crearTecnico3() {
		AltaTecnico a = new AltaTecnicoImpl();
		a.registrarTecnico("tecnico3", "tecnico3", "tecnico3", "tecnico3",
				new Date(), "tecnico3", "955555555");
	}

	@Test
	public void crearProducto1() {
		AltaProducto a = new AltaProductoImpl();
		a.datosProducto("Webcam1", "Webcam", "webcam");
		AltaProcedimiento p1 = new AltaProcedimientoImpl();
		p1.introducirDatosProcedimiento("WC1", "WC1", "WC1");
		AltaProcedimiento p2 = new AltaProcedimientoImpl();
		p2.introducirDatosProcedimiento("WC2", "WC2", "WC2");
		AltaProcedimiento p3 = new AltaProcedimientoImpl();
		p3.introducirDatosProcedimiento("WC3", "WC3", "WC3");
		Set<String> s = new HashSet<String>();
		for (Procedimiento p : a.listarProcedimientos()) {
			s.add(p.getCodigo());
		}
		a.seleccionarProcedimientos(s);
		a.registrarProducto();

	}

	@Test
	public void crearProducto2() {
		AltaProducto a = new AltaProductoImpl();
		a.datosProducto("P16", "Pendrive 16GB", "Pendrive 16GB");
		AltaProcedimiento p1 = new AltaProcedimientoImpl();
		p1.introducirDatosProcedimiento("PD1", "PD1", "PD1");
		Set<String> s = new HashSet<String>();
		s.add("PD1");
		a.seleccionarProcedimientos(s);
		a.registrarProducto();

	}

	@Test
	public void crearProducto3() {
		AltaProducto a = new AltaProductoImpl();
		a.datosProducto("P32", "Pendrive 32GB", "Pendrive 32GB");
		Set<String> s = new HashSet<String>();
		s.add("PD1");
		a.seleccionarProcedimientos(s);
		a.registrarProducto();

	}

	@Test
	public void crearProducto4() {
		AltaProducto a = new AltaProductoImpl();
		a.datosProducto("M24", "Monitor 24in", "Monitor 24in");
		AltaProcedimiento p1 = new AltaProcedimientoImpl();
		p1.introducirDatosProcedimiento("M1", "M1", "M1");
		AltaProcedimiento p2 = new AltaProcedimientoImpl();
		p2.introducirDatosProcedimiento("M2", "M2", "M2");
		AltaProcedimiento p3 = new AltaProcedimientoImpl();
		p3.introducirDatosProcedimiento("M3", "M3", "M3");
		AltaProcedimiento p4 = new AltaProcedimientoImpl();
		p4.introducirDatosProcedimiento("M4", "M4", "M4");
		Set<String> s = new HashSet<String>();
		s.add("M1");
		s.add("M2");
		s.add("M3");
		s.add("M4");
		a.seleccionarProcedimientos(s);
		a.registrarProducto();

	}

	@Test
	public void crearProducto5() {
		AltaProducto a = new AltaProductoImpl();
		a.datosProducto("M32", "Monitor 32in", "Monitor 32in");
		Set<String> s = new HashSet<String>();
		s.add("M1");
		s.add("M2");
		s.add("M3");
		a.seleccionarProcedimientos(s);
		a.registrarProducto();
	}

	@Test
	public void asignarProcedimientos1() {
		AltaAsociacion a = new AltaAsociacionImpl();
		a.seleccionarTecnico("tecnico1");
		Set<String> s = new HashSet<String>();
		s.add("WC1");
		s.add("WC2");
		s.add("WC3");
		a.asignarProcedimientos(s);
	}

	@Test
	public void asignarProcedimientos2() {
		AltaAsociacion a = new AltaAsociacionImpl();
		a.seleccionarTecnico("tecnico2");
		Set<String> s = new HashSet<String>();
		s.add("PD1");
		s.add("WC2");
		s.add("WC3");
		s.add("WC1");
		a.asignarProcedimientos(s);
	}

	@Test
	public void asignarProcedimientos3() {
		AltaAsociacion a = new AltaAsociacionImpl();
		a.seleccionarTecnico("tecnico3");
		Set<String> s = new HashSet<String>();
		s.add("PD1");
		s.add("WC2");
		s.add("WC3");
		s.add("WC1");
		s.add("M1");
		s.add("M2");
		s.add("M3");
		a.asignarProcedimientos(s);
	}

	@Test
	public void altaIncidencia1() {
		AltaIncidencia a = new AltaIncidenciaImpl();
		a.introducirDescripcionIncidencia("web cam rota");
		a.seleccionarProcedimiento("WC1");
		a.seleccionarProducto("Webcam1");
		a.registrarIncidencia();
	}

	@Test
	public void altaIncidencia2() {
		AltaIncidencia a = new AltaIncidenciaImpl();
		a.introducirDescripcionIncidencia("web cam rota");
		a.seleccionarProcedimiento("WC2");
		a.seleccionarProducto("Webcam1");
		a.registrarIncidencia();
	}

	@Test
	public void altaIncidencia3() {
		AltaIncidencia a = new AltaIncidenciaImpl();
		a.introducirDescripcionIncidencia("pendrive roto");
		a.seleccionarProcedimiento("PD1");
		a.seleccionarProducto("P32");
		a.registrarIncidencia();
	}

	@Test
	public void altaIncidencia4() {
		AltaIncidencia a = new AltaIncidenciaImpl();
		a.introducirDescripcionIncidencia("monitor roto");
		a.seleccionarProcedimiento("M1");
		a.seleccionarProducto("M24");
		a.registrarIncidencia();
	}

	@Test
	public void altaIncidencia5() {
		AltaIncidencia a = new AltaIncidenciaImpl();
		a.introducirDescripcionIncidencia("monitor roto");
		a.seleccionarProducto("M32");
		a.registrarIncidencia();
	}

	@Test
	public void consultaIncidencia1() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		assert (a.listarIncidenciasSinAsignar("tecnico1").size() == 2);
	}

	@Test
	public void consultaIncidencia2() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		assert (a.listarIncidenciasSinAsignar("tecnico2").size() == 3);
	}

	@Test
	public void consultaIncidencia3() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		assert (a.listarIncidenciasSinAsignar("tecnico3").size() == 4);
	}

	@Test
	public void asignarIncidencia1() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		a.listarIncidenciasSinAsignar("tecnico1");
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		a.asociarIncidencia(s);
	}

	@Test(expected = InvalidStateException.class)
	public void asignarIncidencia2() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		a.listarIncidenciasSinAsignar("tecnico2");
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		a.asociarIncidencia(s);
	}

	@Test(expected = InvalidStateException.class)
	public void asignarIncidencia3() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		a.listarIncidenciasSinAsignar("tecnico3");
		Set<Integer> s = new HashSet<Integer>();
		s.add(2);
		a.asociarIncidencia(s);
	}

	@Test
	public void asignarIncidencia4() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		a.listarIncidenciasSinAsignar("tecnico2");
		Set<Integer> s = new HashSet<Integer>();
		s.add(3);
		a.asociarIncidencia(s);
	}

	@Test(expected = InvalidStateException.class)
	public void asignarIncidencia5() {
		AsignarIncidencia a = new AsignarIncidenciaImpl();
		a.listarIncidenciasSinAsignar("tecnico3");
		Set<Integer> s = new HashSet<Integer>();
		s.add(3);
		a.asociarIncidencia(s);
	}

	@Test
	public void resolverIncidencia1() {
		ResponderIncidencia r = new ResponderIncidenciaImpl();
		assert (r.listarIncidenciasTecnicoSinRespuesta("tecnico1").size() == 1);
		r.seleccionarIncidencia(1);
		r.anadirDescripcion("Producto reparado!");
		r.registrarRespuesta();
	}

	@Test
	public void valorarIncidencia1() {
		ValorarIncidencia v = new ValorarIncidenciaImpl();
		v.registrarValoracion(1, -5);
	}

	@Test
	public void altaIncidencia6() {
		AltaIncidencia a = new AltaIncidenciaImpl();
		a.introducirDescripcionIncidencia("esto sigue sin funcionar.");
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		a.seleccionarProducto("Webcam1");
		a.seleccionarProcedimiento("WC1");
		a.seleccionarIncidenciasRelacionadas(s);
		a.registrarIncidencia();
	}

}
