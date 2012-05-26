package isw2;


import org.junit.Before;
import org.junit.Test;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.implementaciones.ProcedimientoImpl;

public class TestProcedimiento {

	Procedimiento p;

	@Before
	public void setup() {
		p = new ProcedimientoImpl("1", "MON-01", "Reparaci�n conector USB");
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
		p.setNombre("MON-02");

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
		p.setDescripcion("Reparaci�n pines del usb");

	}

	public void testSetDadoDeBaja2() {
		p.setDadoDeBaja(true);

	}

}
