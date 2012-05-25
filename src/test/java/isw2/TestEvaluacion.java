package isw2;

import java.util.HashSet;
import java.util.Set;

import isw2.entidades.contratos.Procedimiento;
import isw2.servicio.procedimiento.AltaProcedimiento;
import isw2.servicio.procedimiento.AltaProcedimientoImpl;
import isw2.servicio.producto.AltaProducto;
import isw2.servicio.producto.AltaProductoImpl;
import isw2.servicio.tecnico.AltaTecnico;
import isw2.servicio.tecnico.AltaTecnicoImpl;

import org.junit.Before;
import org.junit.Test;

public class TestEvaluacion {

	@Before
	public void setup() {

	}

	@Test
	public void crearTecnico1() {
		AltaTecnico a = new AltaTecnicoImpl();
		a.introducirCredenciales("tecnico1", "tecnico1");
		a.registrarTecnico();
	}

	@Test
	public void crearTecnico2() {
		AltaTecnico a = new AltaTecnicoImpl();
		a.introducirCredenciales("tecnico2", "tecnico2");
		a.registrarTecnico();
	}

	@Test
	public void crearTecnico3() {
		AltaTecnico a = new AltaTecnicoImpl();
		a.introducirCredenciales("tecnico3", "tecnico3");
		a.registrarTecnico();
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

}
