package isw2.entidades.implementaciones;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Target;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;
import isw2.entidades.contratos.Respuesta;
import isw2.entidades.contratos.Tecnico;
import isw2.excepciones.InvalidStateException;

@Entity
@Table(name = "Incidencia")
public class IncidenciaImpl implements Incidencia, Serializable {

	private static final long serialVersionUID = 5968571211363104822L;
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private String dni;
	private String email;
	private String descripcion;
	private Date fecha;
	@Embedded
	@Target(RespuestaImpl.class)
	private Respuesta respuesta;
	@ManyToOne(targetEntity = TecnicoImpl.class)
	private Tecnico tecnico;
	@ManyToOne(targetEntity = ProcedimientoImpl.class)
	private Procedimiento procedimiento;
	@ManyToOne(targetEntity = ProductoImpl.class)
	private Producto producto;
	@ManyToMany(targetEntity = IncidenciaImpl.class)
	private Set<Incidencia> incidencias;

	public IncidenciaImpl() {
	}

	public IncidenciaImpl(String nombre, String dni, String email,
			String descripcion, Date fecha) {
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.incidencias = new HashSet<Incidencia>();
	}

	public String getNombreCliente() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaCompra() {
		return fecha;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public Producto getProducto() {
		return producto;
	}

	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void anadirIncidencia(Incidencia incidencia) {
		if (incidencia == null)
			throw new NullPointerException();
		else if (getIncidencias().contains(incidencia))
			throw new IllegalArgumentException();
		incidencias.add(incidencia);
	}

	public void setRespuesta(Respuesta respuesta) throws InvalidStateException {
		if (respuesta == null)
			throw new NullPointerException();
		else if (getRespuesta() != null)
			throw new InvalidStateException();
		this.respuesta = respuesta;
	}

	public void setTecnico(Tecnico tecnico) throws InvalidStateException {
		if (tecnico == null)
			throw new NullPointerException();
		else if (tecnico.getDadoDeBaja())
			throw new IllegalArgumentException();
		else if (getTecnico() != null)
			throw new IllegalArgumentException("Incidencia ya asignada.");
		this.tecnico = tecnico;
	}

	public void setProcedimiento(Procedimiento procedimiento)
			throws InvalidStateException {
		if (procedimiento != null) {
			if (procedimiento.getDadoDeBaja())
				throw new IllegalArgumentException();
			else if (getProcedimiento() != null)
				throw new InvalidStateException();
		}
		this.procedimiento = procedimiento;

	}

	public void setProducto(Producto producto) throws InvalidStateException {
		if (producto == null)
			throw new NullPointerException();
		else if (producto.getDadoDeBaja())
			throw new IllegalArgumentException();
		else if (getProducto() != null)
			throw new InvalidStateException();
		this.producto = producto;

	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		IncidenciaImpl other = (IncidenciaImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {

		return "id: " + getId() + " dni usuario: " + getDni()
				+ " descripcion: " + getDescripcion();
	}

}
