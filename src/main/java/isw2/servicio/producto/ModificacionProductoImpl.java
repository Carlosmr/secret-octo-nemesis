package isw2.servicio.producto;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioProductosImpl;

import java.util.Set;

public class ModificacionProductoImpl implements ModificacionProducto {

	private RepositorioProductosImpl rp;
	private String nombre;
	private String descripcion;
	private RepositorioProcedimientosImpl rpr;
	private Set<Procedimiento> procedimientos;
	private Producto producto;

	public ModificacionProductoImpl() {
		rp = new RepositorioProductosImpl();
		rpr = new RepositorioProcedimientosImpl();
	}

	public Set<Producto> listarProductosDadosDeAlta() {
		return rp.getProductosDadosDeAlta();
	}

	public Set<Producto> listarProductos() {
		return rp.getProductos();
	}

	public Producto seleccionaProducto(String codigo) {
		producto = rp.getProducto(codigo);
		return producto;
	}

	public void guardarDatosProducto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Set<Procedimiento> listarProcedimientosDadosDeAlta() {
		return rpr.getProcedimientosDadosDeAlta();
	}

	public Set<Procedimiento> listarProcedimientos() {
		return rpr.getProcedimientos();
	}

	public void guardarProcedimientos(Set<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}

	public void registrarDatos() {
		producto.setDescripcion(descripcion);
		producto.setNombre(nombre);
		for (Procedimiento p : procedimientos)
			producto.anadirProcedimiento(p);
	}

}
