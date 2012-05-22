package isw2;

import org.junit.Before;
import org.junit.Test;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.implementaciones.RespuestaImpl;

public class TestRespuesta {

	Respuesta r;

	@Before
	public void setup() {
		r = new RespuestaImpl(
				"Trato muy correcto, en dos d�as estaba reparado.");
	}

	@Test
	public void testSetValoracion1() {
		r.setValoracion(5);
	}

	@Test(expected = NullPointerException.class)
	public void testSetValoracion2() {
		r.setValoracion(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValoracion3() {
		r.setValoracion(6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValoracion4() {
		r.setValoracion(-6);
	}

	@Test
	public void testSetValoracion5() {
		r.setValoracion(-5);
	}

}
