package isw2.servicio.producto;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Producto;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioProductosImpl;
import java.util.HashSet;
import java.util.Set;

public class AltaProductoImpl implements AltaProducto {

	private RepositorioProductosImpl rp;
	private RepositorioProcedimientosImpl rpr;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Set<Procedimiento> procedimientos = new HashSet<Procedimiento>();

	public AltaProductoImpl() {
		rp = new RepositorioProductosImpl();
		rpr = new RepositorioProcedimientosImpl();
	}

	public void datosProducto(String codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Set<Procedimiento> listarProcedimientos() {
		return rpr.getProcedimientos();
	}

	public Set<Procedimiento> listarProcedimientosDadosDeAlta() {
		return rpr.getProcedimientosDadosDeAlta();
	}

	public void seleccionarProcedimientos(Set<String> idProcedimientos) {
		procedimientos = new HashSet<Procedimiento>();
		for (String s : idProcedimientos)
			procedimientos.add(rpr.getProcedimiento(s));

	}

	public void registrarProducto() {
		Producto p = rp.crearProducto(codigo, nombre, descripcion);
		for (Procedimiento pr : procedimientos) {
			p.anadirProcedimiento(pr);
		}
		rp.guardar(p);
	}

}
