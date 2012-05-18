package isw2;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.entidades.implementaciones.TecnicoImpl;

@SuppressWarnings("deprecation")
public class TestTecnico {

	Tecnico t;

	@Before
	public void setup() {
		t = new TecnicoImpl("marioml", "m22385", "Mario", "Molina Lara",
				new Date(1990, 10, 21), "C/ Guadalquivir, 13", "954556356");
	}

	@Test
	public void testSetNombre1() {
		t.setNombre("Jorge");
	}

	@Test(expected = NullPointerException.class)
	public void testSetNombre2() {
		t.setNombre(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNombre3() {
		t.setNombre("");
	}

	@Test
	public void testSetUser1() {
		t.setUser("jorge32");
	}

	@Test(expected = NullPointerException.class)
	public void testSetUser2() {
		t.setUser(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetUser3() {
		t.setUser("");
	}

	@Test
	public void testSetPassword1() {
		t.setPassword("j32o55r");
	}

	@Test(expected = NullPointerException.class)
	public void testSetPassword2() {
		t.setPassword(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPassword3() {
		t.setPassword("jorge1");
	}

	@Test
	public void testSetApellidos1() {
		t.setApellidos("Macias Lara");
	}

	@Test(expected = NullPointerException.class)
	public void testSetApellidos2() {
		t.setApellidos(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetApellidos3() {
		t.setApellidos("");
	}

	@Test
	public void testSetFechaNacimiento1() {
		Date d = new Date(1988, 11, 3);
		t.setFechaNacimiento(d);
	}

	@Test(expected = NullPointerException.class)
	public void testSetFechaNacimiento2() {
		t.setFechaNacimiento(null);
	}

	@Test
	public void testSetDireccion1() {
		t.setDireccion("C/Guadalate, 3");
	}

	@Test(expected = NullPointerException.class)
	public void testSetDireccion2() {
		t.setDireccion(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDireccion3() {
		t.setDireccion("");
	}

	@Test
	public void testSetTelefono1() {
		t.setTelefono("954190012");
	}

	@Test(expected = NullPointerException.class)
	public void testSetTelefono2() {
		t.setTelefono(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTelefono3() {
		t.setTelefono("23334");
	}

	@Test
	public void testSetDadoDeBaja1() {
		t.setDadoDeBaja(true);
	}

	@Test(expected = NullPointerException.class)
	public void testSetDadoDeBaja2() {
		t.setDadoDeBaja(null);
	}

	@Test
	public void testAñadirProcedimiento1() {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		t.añadirProcedimiento(p);
	}

	@Test(expected = NullPointerException.class)
	public void testAñadirProcedimiento2() {
		t.añadirProcedimiento(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAñadirProcedimiento3() {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		p.setDadoDeBaja(true);
		t.añadirProcedimiento(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAñadirProcedimiento4() {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		t.añadirProcedimiento(p);
		t.añadirProcedimiento(p);
	}

	@Test
	public void testAñadirProcedimiento5() {
		Procedimiento p1 = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		Procedimiento p2 = new ProcedimientoImpl("2", "MON-02",
				"Reparación conector USB");
		Procedimiento p3 = new ProcedimientoImpl("3", "MON-03",
				"Reparación conector USB");
		Procedimiento p4 = new ProcedimientoImpl("4", "MON-04",
				"Reparación conector USB");
		Procedimiento p5 = new ProcedimientoImpl("5", "MON-05",
				"Reparación conector USB");
		Procedimiento p6 = new ProcedimientoImpl("6", "MON-06",
				"Reparación conector USB");
		Procedimiento p7 = new ProcedimientoImpl("7", "MON-07",
				"Reparación conector USB");
		Procedimiento p8 = new ProcedimientoImpl("8", "MON-08",
				"Reparación conector USB");
		Procedimiento p9 = new ProcedimientoImpl("9", "MON-09",
				"Reparación conector USB");
		Procedimiento p10 = new ProcedimientoImpl("10", "MON-10",
				"Reparación conector USB");
		t.añadirProcedimiento(p1);
		t.añadirProcedimiento(p2);
		t.añadirProcedimiento(p3);
		t.añadirProcedimiento(p4);
		t.añadirProcedimiento(p5);
		t.añadirProcedimiento(p6);
		t.añadirProcedimiento(p7);
		t.añadirProcedimiento(p8);
		t.añadirProcedimiento(p9);
		t.añadirProcedimiento(p10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAñadirProcedimiento6() {
		Procedimiento p1 = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		Procedimiento p2 = new ProcedimientoImpl("2", "MON-02",
				"Reparación conector USB");
		Procedimiento p3 = new ProcedimientoImpl("3", "MON-03",
				"Reparación conector USB");
		Procedimiento p4 = new ProcedimientoImpl("4", "MON-04",
				"Reparación conector USB");
		Procedimiento p5 = new ProcedimientoImpl("5", "MON-05",
				"Reparación conector USB");
		Procedimiento p6 = new ProcedimientoImpl("6", "MON-06",
				"Reparación conector USB");
		Procedimiento p7 = new ProcedimientoImpl("7", "MON-07",
				"Reparación conector USB");
		Procedimiento p8 = new ProcedimientoImpl("8", "MON-08",
				"Reparación conector USB");
		Procedimiento p9 = new ProcedimientoImpl("9", "MON-09",
				"Reparación conector USB");
		Procedimiento p10 = new ProcedimientoImpl("10", "MON-10",
				"Reparación conector USB");
		Procedimiento p11 = new ProcedimientoImpl("11", "MON-11",
				"Reparación conector USB");
		t.añadirProcedimiento(p1);
		t.añadirProcedimiento(p2);
		t.añadirProcedimiento(p3);
		t.añadirProcedimiento(p4);
		t.añadirProcedimiento(p5);
		t.añadirProcedimiento(p6);
		t.añadirProcedimiento(p7);
		t.añadirProcedimiento(p8);
		t.añadirProcedimiento(p9);
		t.añadirProcedimiento(p10);
		t.añadirProcedimiento(p11);
	}

	@Test
	public void testEliminaProcedimiento1() {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		t.añadirProcedimiento(p);
		t.eliminaProcedimiento(p);
	}

	@Test(expected = NullPointerException.class)
	public void testEliminaProcedimiento2() {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		t.añadirProcedimiento(p);
		t.eliminaProcedimiento(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEliminaProcedimiento() {
		Procedimiento p = new ProcedimientoImpl("1", "MON-01",
				"Reparación conector USB");
		t.eliminaProcedimiento(p);
	}
}
