package isw2.implementaciones;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import isw2.entidades.Incidencia;
import isw2.entidades.Procedimiento;
import isw2.entidades.Producto;
import isw2.entidades.Respuesta;
import isw2.entidades.Tecnico;
import isw2.excepciones.InvalidStateException;

public class IncidenciaImpl implements Incidencia {

	private Integer id;
	private String nombre;
	private String dni;
	private String email;
	private String descripcion;
	private Date fecha;
	private Respuesta respuesta;
	private Tecnico tecnico;
	private Procedimiento procedimiento;
	private Producto producto;
	private Set<Incidencia> incidencias;

	public IncidenciaImpl(Integer id, String nombre, String dni, String email,
			String descripcion, Date fecha) {
		this.id = id;
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

	public void añadirIncidencia(Incidencia incidencia) {
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
			throw new InvalidStateException();
		this.tecnico = tecnico;
	}

	public void setProcedimiento(Procedimiento procedimiento)
			throws InvalidStateException {
		if (procedimiento == null)
			throw new NullPointerException();
		else if (procedimiento.getDadoDeBaja())
			throw new IllegalArgumentException();
		else if (getProcedimiento() != null)
			throw new InvalidStateException();
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

}
