package isw2.entidades.contratos;

import java.util.Date;
import java.util.Set;

import isw2.excepciones.InvalidStateException;

import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

public interface Incidencia {

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
			"forall Incidencia i: getIncidencias()@pre · getIncidencias().contains(i)",
			"getIncidencias().size()==getIncidencias().size()@pre+1",
			"getNombreCliente()==getNombreCliente()@pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getFechaCompra()==getFechaCompra()@pre",
			"getRespuesta()==getRespuesta()@pre",
			"getProcedimiento()==getProcedimiento()@pre",
			"getProducto==getProducto()@pre", "getTecnico()==getTecnico()@pre" })
	void anadirIncidencia(Incidencia incidencia);

	@Pre({ "tecnico!=null #NullPointerException",
			"getTecnico()==null #InvalidStateException",
			"tecnico.getDadoDeBaja()==false #IllegalArgumentException" })
	@Pos({ "getTecnico().equals(tecnico)",
			"getNombreCliente()==getNombreCliente()@pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getFechaCompra()==getFechaCompra()@pre",
			"getRespuesta()==getRespuesta()@pre",
			"getProcedimiento()==getProcedimiento()@pre",
			"getProducto==getProducto()@pre",
			"getIncidencias==getIncidencias()@pre" })
	void setTecnico(Tecnico tecnico) throws InvalidStateException;

	@Pre({ "procedimiento!=null #NullPointerException",
			"!procedimiento.getDadoDeBaja() #IllegalArgumentException",
			"getProcedimiento()==null #InvalidStateException" })
	@Pos({ "getProcedimiento().equals(procedimiento)",
			"getNombreCliente()==getNombreCliente()@pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getFechaCompra()==getFechaCompra()@pre",
			"getRespuesta()==getRespuesta()@pre",
			"getTecnico()==getTecnico()@pre", "getProducto==getProducto()@pre",
			"getIncidencias==getIncidencias()@pre" })
	void setProcedimiento(Procedimiento procedimiento)
			throws InvalidStateException;

	@Pre({ "producto!=null #NullPointerException",
			"!producto.getDadoDeBaja() #IllegalArgumentException",
			"getProducto()==null #InvalidStateException" })
	@Pos({ "getIncidencia().equals(producto)",
			"getNombreCliente()==getNombreCliente()@pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getFechaCompra()==getFechaCompra()@pre",
			"getRespuesta()==getRespuesta()@pre",
			"getProcedimiento()==getProcedimiento()@pre",
			"getTecnico==getTecnico()@pre",
			"getIncidencias==getIncidencias()@pre" })
	void setProducto(Producto producto) throws InvalidStateException;

	@Pre({ "respuesta!=null #NullPointerException",
			"getRespuesta()==null #InvalidStateException" })
	@Pos({ "getRespuesta().equals(respuesta)",
			"getNombreCliente()==getNombreCliente()@pre",
			"getDNI()==getDNI()@pre", "getEmail()==getEmail()@pre",
			"getDescripcion()==getDescripcion()@pre",
			"getFechaCompra()==getFechaCompra()@pre",
			"getTecnico()==getTecnico()@pre",
			"getProcedimiento()==getProcedimiento()@pre",
			"getProducto==getProducto()@pre",
			"getIncidencias==getIncidencias()@pre" })
	void setRespuesta(Respuesta respuesta) throws InvalidStateException;

}
