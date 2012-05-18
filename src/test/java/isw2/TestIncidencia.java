package isw2;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.IncidenciaImpl;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.entidades.implementaciones.ProductoImpl;
import isw2.entidades.implementaciones.RespuestaImpl;
import isw2.entidades.implementaciones.TecnicoImpl;
import isw2.excepciones.InvalidStateException;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class TestIncidencia {

	Incidencia i;

	@Before
	public void setup() {
		i = new IncidenciaImpl("Jorge Martinez", "54869468F",
				"jmartinez@gmail.com", "El conector USB no funciona.",
				new Date(2012, 3, 12));
	}

	@Test
	public void testAñadirIncidencia1() {
		Incidencia e = new IncidenciaImpl("Jorge Martinez", "54869468F",
				"jmartinez@gmail.com", "La pantalla se ve en negro.", new Date(
						2011, 9, 13));
		i.añadirIncidencia(e);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAñadirIncidencia2() {
		Incidencia e = new IncidenciaImpl("Jorge Martinez", "54869468F",
				"jmartinez@gmail.com", "La pantalla se ve en negro.", new Date(
						2011, 9, 13));
		i.añadirIncidencia(e);
		i.añadirIncidencia(e);
	}

	@Test(expected = NullPointerException.class)
	public void testAñadirIncidencia3() {
		i.añadirIncidencia(null);
	}

	@Test
	public void testSetTecnico1() throws InvalidStateException {
		Tecnico t = new TecnicoImpl("marioml", "m22385", "Mario",
				"Molina Lara", new Date(1990, 10, 21), "C/ Guadalquivir, 13",
				"954556356");
		i.setTecnico(t);
	}

	@Test(expected = NullPointerException.class)
	public void testSetTecnico2() throws InvalidStateException {
		i.setTecnico(null);
	}

	@Test(expected = InvalidStateException.class)
	public void testSetTecnico3() throws InvalidStateException {
		Tecnico t1 = new TecnicoImpl("marioml", "m22385", "Mario",
				"Molina Lara", new Date(1990, 10, 21), "C/ Guadalquivir, 13",
				"954556356");
		Tecnico t2 = new TecnicoImpl("jherrera", "jh23rr", "Jose",
				"Herrera Perez", new Date(1988, 3, 21), "C/ Enmedio, 3",
				"954553426");
		i.setTecnico(t1);
		i.setTecnico(t2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTecnico4() throws InvalidStateException {
		Tecnico t = new TecnicoImpl("marioml", "m22385", "Mario",
				"Molina Lara", new Date(1990, 10, 21), "C/ Guadalquivir, 13",
				"954556356");
		t.setDadoDeBaja(true);
		i.setTecnico(t);
	}

	@Test
	public void testSetProcedimiento1() throws InvalidStateException {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		i.setProcedimiento(p);
	}

	@Test(expected = NullPointerException.class)
	public void testSetProcedimiento2() throws InvalidStateException {
		i.setProcedimiento(null);
	}

	@Test(expected = InvalidStateException.class)
	public void testSetProcedimiento3() throws InvalidStateException {
		Procedimiento p1 = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		Procedimiento p2 = new ProcedimientoImpl("2", "MON-02",
				"Reparación pantalla");
		i.setProcedimiento(p1);
		i.setProcedimiento(p2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetProcedimiento4() throws InvalidStateException {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		p.setDadoDeBaja(true);
		i.setProcedimiento(p);
	}

	@Test
	public void testSetProducto1() throws InvalidStateException {
		Producto p = new ProductoImpl("1", "MON-LG-01", "Monitor LG de 23\" ");
		i.setProducto(p);
	}

	@Test(expected = NullPointerException.class)
	public void testSetProducto2() throws InvalidStateException {
		i.setProducto(null);
	}

	@Test(expected = InvalidStateException.class)
	public void testSetProducto3() throws InvalidStateException {
		Producto p1 = new ProductoImpl("1", "MON-LG-01", "Monitor LG de 23\" ");
		Producto p2 = new ProductoImpl("2", "MON-LG-02", "Monitor LG de 21\" ");
		i.setProducto(p1);
		i.setProducto(p2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetProducto4() throws InvalidStateException {
		Producto p = new ProductoImpl("1", "MON-LG-01", "Monitor LG de 23 \"");
		p.setDadoDeBaja(true);
		i.setProducto(p);
	}

	@Test
	public void testSetRespuesta1() throws InvalidStateException {
		Respuesta r = new RespuestaImpl(3,
				"Problema solucionado, todo muy rapido.");
		i.setRespuesta(r);
	}

	@Test(expected = NullPointerException.class)
	public void testSetRespuesta2() throws InvalidStateException {
		i.setRespuesta(null);
	}

	@Test(expected = InvalidStateException.class)
	public void testSetRespuesta3() throws InvalidStateException {
		Respuesta r1 = new RespuestaImpl(3,
				"Problema solucionado, todo muy rapido.");
		Respuesta r2 = new RespuestaImpl(-3, "Sigue funcionando mal.");
		i.setRespuesta(r1);
		i.setRespuesta(r2);
	}
}
