package isw2.entidades.implementaciones;

import isw2.entidades.contratos.Procedimiento;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Procedimiento")
public class ProcedimientoImpl implements Procedimiento, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2143314761492084326L;
	@Id
	private String codigo;
	private String nombre;
	private String descripcion;
	private boolean dadoDeBaja;

	public ProcedimientoImpl() {
	}

	public ProcedimientoImpl(String codigo, String nombre, String descripcion) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dadoDeBaja = false;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo == null)
			throw new NullPointerException();
		else if (codigo == "")
			throw new IllegalArgumentException();
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new NullPointerException();
		else if (nombre == "")
			throw new IllegalArgumentException();
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null)
			throw new NullPointerException();
		else if (descripcion == "")
			throw new IllegalArgumentException();
		this.descripcion = descripcion;
	}

	public boolean getDadoDeBaja() {
		return dadoDeBaja;
	}

	public void setDadoDeBaja(boolean dadoDeBaja) {
		this.dadoDeBaja = dadoDeBaja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcedimientoImpl other = (ProcedimientoImpl) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String toString() {

		// TODO eliminar toString, solo se utiliza para testear en el EntryPoint

		return "codigo " + getCodigo() + " nombre " + getNombre();

	}

}
