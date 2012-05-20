package isw2;

import org.junit.Before;
import org.junit.Test;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.entidades.implementaciones.ProductoImpl;

public class TestProducto {

	Producto p;

	@Before
	public void setup() {

		p = new ProductoImpl("1234", "pen drive", "Memoria flash usb 4Gb");

	}

	@Test(expected = NullPointerException.class)
	public void testSetNombre1() {
		p.setNombre(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNombre2() {
		p.setNombre("");

	}

	@Test()
	public void testSetNombre3() {
		p.setNombre("pen-drive");

	}

	@Test(expected = NullPointerException.class)
	public void testSetDescripcion1() {
		p.setDescripcion(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDescripcion2() {
		p.setDescripcion("");

	}

	@Test()
	public void testSetDescripcion3() {
		p.setDescripcion("Memoria usb");

	}

	@Test(expected = NullPointerException.class)
	public void testSetDadoDeBaja1() {
		p.setDadoDeBaja(null);

	}

	@Test()
	public void testSetDadoDeBaja2() {
		p.setDadoDeBaja(true);

	}

	@Test(expected = NullPointerException.class)
	public void testAnadirProcedimiento1() {
		p.anadirProcedimiento(null);

	}

	@Test
	public void testAnadirProcedimiento2() {
		Procedimiento proc1 = new ProcedimientoImpl("1234", "MON-01",
				"repacion conector usb");

		p.anadirProcedimiento(proc1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAnadirProcedimiento3() {
		Procedimiento proc1 = new ProcedimientoImpl("1234", "MON-01",
				"repacion conector usb");
		p.anadirProcedimiento(proc1);
		p.anadirProcedimiento(proc1);

	}

	@Test(expected = NullPointerException.class)
	public void testEliminarProcedimiento1() {
		p.anadirProcedimiento(null);

	}

	@Test
	public void testEliminarProcedimiento2() {
		Procedimiento proc1 = new ProcedimientoImpl("1234", "MON-01",
				"repacion conector usb");
		p.anadirProcedimiento(proc1);
		p.eliminarProcedimiento(proc1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testEliminarProcedimiento3() {
		Procedimiento proc1 = new ProcedimientoImpl("1234", "MON-01",
				"repacion conector usb");
		p.eliminarProcedimiento(proc1);

	}

}
