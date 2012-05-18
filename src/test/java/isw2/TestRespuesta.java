package isw2;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import isw2.entidades.Incidencia;
import isw2.entidades.Respuesta;
import isw2.excepciones.InvalidStateException;

import isw2.implementaciones.IncidenciaImpl;
import isw2.implementaciones.RespuestaImpl;

@SuppressWarnings("deprecation")
public class TestRespuesta {

	Respuesta r;

	@Before
	public void setup() {
		r = new RespuestaImpl(4,
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

	@Test
	public void testSetIncidencia1() throws InvalidStateException {
		Incidencia i = new IncidenciaImpl(1, "Jorge Martinez", "54869468F",
				"jmartinez@gmail.com", "El conector USB no funciona.",
				new Date(2012, 3, 12));
		r.setIncidencia(i);
	}

	@Test(expected = NullPointerException.class)
	public void testSetIncidencia2() throws InvalidStateException {
		r.setIncidencia(null);
	}

	@Test(expected = InvalidStateException.class)
	public void testSetIncidencia3() throws InvalidStateException {
		Incidencia i = new IncidenciaImpl(1, "Jorge Martinez", "54869468F",
				"jmartinez@gmail.com", "El conector USB no funciona.",
				new Date(2012, 3, 12));
		r.setIncidencia(i);
		r.setIncidencia(i);
	}

}
