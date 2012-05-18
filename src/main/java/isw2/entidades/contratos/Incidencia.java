package isw2.entidades.contratos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import isw2.excepciones.InvalidStateException;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

public interface Incidencia extends Serializable{

	Integer getId();
	
	@Query
	@Pre({ "true" })
	String getNombreCliente();

	@Query
	@Pre({ "true" })
	String getDni();

	@Query
	@Pre({ "true" })
	String getEmail();

	@Query
	@Pre({ "true" })
	String getDescripcion();

	@Query
	@Pre({ "true" })
	Date getFechaCompra();

	@Query
	@Pre({ "true" })
	Respuesta getRespuesta();

	@Query
	@Pre({ "true" })
	Tecnico getTecnico();

	@Query
	@Pre({ "true" })
	Procedimiento getProcedimiento();

	@Query
	@Pre({ "true" })
	Producto getProducto();

	@Query
	@Pre({ "true" })
	Set<Incidencia> getIncidencias();

	@Pre({ "incidencia != null #NullPointerException",
			"!getIncidencias().contains(incidencia) #IllegalArgumentException" })
	@Pos({
			"getIncidencias().contains(incidencia)",
			"forall Incidencia i: getIncidencias()@Pre � getIncidencias().contains(i)",
			"getIncidencias().size()==getIncidencias().size()@Pre+1",
			"getNombreCliente()==getNombreCliente()@Pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getFechaCompra()==getFechaCompra()@Pre",
			"getRespuesta()==getRespuesta()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getProducto==getProducto()@Pre", "getTecnico()==getTecnico()@Pre" })
	void añadirIncidencia(Incidencia incidencia);

	@Pre({ "tecnico!=null #NullPointerException",
			"getTecnico()==null #InvalidStateException",
			"tecnico.getDadoDeBaja()==false #IllegalArgumentException" })
	@Pos({ "getTecnico().equals(tecnico)",
			"getNombreCliente()==getNombreCliente()@Pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getFechaCompra()==getFechaCompra()@pre",
			"getRespuesta()==getRespuesta()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getProducto==getProducto()@Pre",
			"getIncidencias==getIncidencias()@Pre" })
	void setTecnico(Tecnico tecnico) throws InvalidStateException;

	@Pre({ "procedimiento!=null #NullPointerException",
			"!procedimiento.getDadoDeBaja() #IllegalArgumentException",
			"getProcedimiento()==null #InvalidStateException" })
	@Pos({ "getProcedimiento().equals(procedimiento)",
			"getNombreCliente()==getNombreCliente()@Pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getFechaCompra()==getFechaCompra()@Pre",
			"getRespuesta()==getRespuesta()@Pre",
			"getTecnico()==getTecnico()@Pre", "getProducto==getProducto()@Pre",
			"getIncidencias==getIncidencias()@Pre" })
	void setProcedimiento(Procedimiento procedimiento)
			throws InvalidStateException;

	@Pre({ "producto!=null #NullPointerException",
			"!producto.getDadoDeBaja() #IllegalArgumentException",
			"getProducto()==null #InvalidStateException" })
	@Pos({ "getIncidencia().equals(producto)",
			"getNombreCliente()==getNombreCliente()@Pre",
			"getDNI()==getDNI()@Pre", "getEmail()==getEmail()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getFechaCompra()==getFechaCompra()@Pre",
			"getRespuesta()==getRespuesta()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getTecnico==getTecnico()@Pre",
			"getIncidencias==getIncidencias()@Pre" })
	void setProducto(Producto producto) throws InvalidStateException;

	@Pre({ "respuesta!=null #NullPointerException",
			"getRespuesta()==null #InvalidStateException" })
	@Pos({ "getRespuesta().equals(respuesta)",
			"getNombreCliente()==getNombreCliente()@Pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@Pre",
			"getDescripcion()==getDescripcion()@Pre",
			"getFechaCompra()==getFechaCompra()@Pre",
			"getTecnico()==getTecnico()@Pre",
			"getProcedimiento()==getProcedimiento()@Pre",
			"getProducto==getProducto()@Pre",
			"getIncidencias==getIncidencias()@Pre" })
	void setRespuesta(Respuesta respuesta) throws InvalidStateException;

}
