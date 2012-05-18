package isw2.implementaciones;

import java.util.HashSet;
import java.util.Set;
import isw2.entidades.Procedimiento;
import isw2.entidades.Producto;

public class ProductoImpl implements Producto {

	private String codigo;
	private String nombre;
	private String descripcion;
	private Boolean dadoDeBaja;
	private Set<Procedimiento> procedimientos = new HashSet<Procedimiento>();

	public ProductoImpl(String codigo, String nombre, String descripcion) {

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

	public Boolean getDadoDeBaja() {
		return dadoDeBaja;
	}

	public void setDadoDeBaja(Boolean dadoDeBaja) {
		if (dadoDeBaja == null)
			throw new NullPointerException();

		this.dadoDeBaja = dadoDeBaja;
	}

	public Set<Procedimiento> getProcedimientos() {

		return procedimientos;
	}

	public void añadirProcedimiento(Procedimiento procedimiento) {

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

}
