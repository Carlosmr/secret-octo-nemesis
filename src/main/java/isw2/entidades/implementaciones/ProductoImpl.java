package isw2.entidades.implementaciones;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;

@Entity
@Table(name = "Producto")
public class ProductoImpl implements Producto, Serializable {

	private static final long serialVersionUID = 6250015112413475753L;
	@Id
	private String codigo;
	private String nombre;
	private String descripcion;
	private boolean dadoDeBaja;
	@ManyToMany(targetEntity = ProcedimientoImpl.class)
	private Set<Procedimiento> procedimientos;

	public ProductoImpl() {
	}

	public ProductoImpl(String codigo, String nombre, String descripcion) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dadoDeBaja = false;
		procedimientos = new HashSet<Procedimiento>();

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

	public Set<Procedimiento> getProcedimientos() {

		return procedimientos;
	}

	public void anadirProcedimiento(Procedimiento procedimiento) {

		if (procedimiento == null)
			throw new NullPointerException();
		else if (getProcedimientos().contains(procedimiento))
			throw new IllegalArgumentException();

		procedimientos.add(procedimiento);

	}

	public void eliminarProcedimiento(Procedimiento procedimiento) {

		if (procedimiento == null)
			throw new NullPointerException();
		else if (!getProcedimientos().contains(procedimiento))
			throw new IllegalArgumentException();

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
		ProductoImpl other = (ProductoImpl) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String toString() {
		// TODO eliminar solo sirve para testear en el EntryPoint

		return getCodigo() + getNombre();
	}

}
