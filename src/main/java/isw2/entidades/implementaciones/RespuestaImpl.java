package isw2.entidades.implementaciones;

import javax.persistence.Embeddable;
import isw2.entidades.contratos.Respuesta;

@Embeddable
public class RespuestaImpl implements Respuesta {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3336398393774226876L;
	private Integer valoracion;
	private String descripcion;
	
	public RespuestaImpl(){}

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

}