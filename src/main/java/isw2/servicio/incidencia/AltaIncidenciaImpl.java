package isw2.servicio.incidencia;

import isw2.entidades.contratos.Incidencia;
import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;
import isw2.excepciones.InvalidStateException;
import isw2.repositorios.RepositorioIncidencias;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioProductos;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioProductosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AltaIncidenciaImpl implements AltaIncidencia {

	private RepositorioIncidencias ri;
	private RepositorioProcedimientos rpr;
	private Set<Incidencia> incidencias;
	private RepositorioProductos rp;
	private Producto producto;
	private String descripcion;
	private Procedimiento procedimiento;
	private String nombreCliente;
	private String dni;
	private String email;
	private Date fechaCompra;

	public AltaIncidenciaImpl() {
		EntityManager em = SingleEntityManager.getEntityManager();
		ri = new RepositorioIncidenciasImpl(em);
		rp = new RepositorioProductosImpl(em);
		rpr = new RepositorioProcedimientosImpl(em);
		incidencias = new HashSet<Incidencia>();

	}

	public Set<Incidencia> seleccionarIncidenciasUsuario(String nombre,
			String dni, String email, Date fechaCompra) {

		this.nombreCliente = nombre;
		this.dni = dni;
		this.email = email;
		this.fechaCompra = fechaCompra;
		return ri.buscarIncidenciasPorDni(dni);
	}

	public void seleccionarIncidenciasRelacionadas(Set<Incidencia> incidencias) {
		this.incidencias.addAll(incidencias);
	}

	public Set<Producto> listarProductos() {
		return rp.getProductos();
	}

	public void seleccionarProducto(String codigo) {
		producto = rp.getProducto(codigo);
	}

	public void introducirDescripcionIncidencia(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Procedimiento> listarProcedimientos() {
		return rpr.getProcedimientos();
	}

	public void seleccionarProcedimiento(String codigo) {
		this.procedimiento = rpr.getProcedimiento(codigo);
	}

	public void registrarIncidencia() {
		Incidencia i = ri.crearIncidencia(nombreCliente, dni, email,
				descripcion, fechaCompra);

		for (Incidencia e : incidencias)
			i.anadirIncidencia(e);
		try {
			i.setProcedimiento(procedimiento);
			i.setProducto(producto);
		} catch (InvalidStateException e1) {
			e1.printStackTrace();
		}

	}
}