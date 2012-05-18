package isw2.implementaciones;

import isw2.entidades.Incidencia;
import isw2.entidades.Respuesta;
import isw2.excepciones.InvalidStateException;

public class RespuestaImpl implements Respuesta {

	private Integer valoracion;
	private String descripcion;
	private Incidencia incidencia;

	public RespuestaImpl(Integer val, String desc) {
		valoracion = val;
		descripcion = desc;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer val) {
		if (val == null)
			throw new NullPointerException();
		else if (val < -5 || val > 5)
			throw new IllegalArgumentException();
		this.valoracion = val;

	}

	public String getDescripcion() {
		return descripcion;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia)
			throws InvalidStateException {
		if (incidencia == null)
			throw new NullPointerException();
		else if (getIncidencia() != null)
			throw new InvalidStateException();
		this.incidencia = incidencia;
	}

}
