package isw2.entidades.implementaciones;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Respuesta;
import isw2.excepciones.InvalidStateException;

@Entity
public class RespuestaImpl implements Respuesta {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3336398393774226876L;
	private Integer valoracion;
	private String descripcion;
	@OneToOne
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
