package isw2.pruebas;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;
import isw2.entidades.implementaciones.ProcedimientoImpl;
import isw2.repositorios.RepositorioIncidencias;
import isw2.repositorios.RepositorioProcedimientos;
import isw2.repositorios.RepositorioProductos;
import isw2.repositorios.RepositorioTecnicos;
import isw2.repositorios.persistencia.RepositorioIncidenciasImpl;
import isw2.repositorios.persistencia.RepositorioJPA;
import isw2.repositorios.persistencia.RepositorioProcedimientosImpl;
import isw2.repositorios.persistencia.RepositorioProductosImpl;
import isw2.repositorios.persistencia.RepositorioTecnicosImpl;
import isw2.repositorios.persistencia.SingleEntityManager;
import isw2.servicio.procedimiento.AltaProcedimiento;
import isw2.servicio.procedimiento.AltaProcedimientoImpl;
import isw2.servicio.producto.AltaProducto;
import isw2.servicio.producto.AltaProductoImpl;
import isw2.servicio.producto.ModificacionProducto;
import isw2.servicio.producto.ModificacionProductoImpl;
import isw2.servicio.tecnico.AltaAsociacion;
import isw2.servicio.tecnico.AltaAsociacionImpl;
import isw2.servicio.tecnico.AltaTecnico;
import isw2.servicio.tecnico.AltaTecnicoImpl;
import isw2.servicio.tecnico.BajaAsociacion;
import isw2.servicio.tecnico.BajaAsociacionImpl;
import isw2.servicio.tecnico.ModificacionTecnico;
import isw2.servicio.tecnico.ModificacionTecnicoImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

public class EntryPoint {

	public static void main(String[] args) {

		AltaTecnico a = new AltaTecnicoImpl();
		a.introducirCredenciales("benito", "benito");
		a.introducirDatosPersonales("benito", "benito", new Date(), "a", "9");
		a.registrarTecnico();
		AltaTecnico a2 = new AltaTecnicoImpl();
		a2.introducirCredenciales("currito", "currito");
		a2.introducirDatosPersonales("curro", "herrera", new Date(),
				"guadalquivir nº 25", "955552321");
		a2.registrarTecnico();
		AltaAsociacion altaA = new AltaAsociacionImpl();
		System.out.println("Tecnicos registrados: "
				+ altaA.listarTecnicosRegistrados());
		EntityManager em = SingleEntityManager.getEntityManager();
		RepositorioTecnicos rt = new RepositorioTecnicosImpl(em);
		RepositorioProductos rp = new RepositorioProductosImpl(em);
		RepositorioProcedimientos rpro = new RepositorioProcedimientosImpl(em);
		RepositorioIncidencias ri = new RepositorioIncidenciasImpl(em);
		System.out
				.println("-------------------------------------------------------------------------------");

		AltaProcedimiento altaProcedimiento = new AltaProcedimientoImpl();
		altaProcedimiento.introducirDatosProcedimiento("0000", "rotura usb",
				"conectores de la entrada del usb no funcionan");
		AltaProcedimiento altaProcedimiento1 = new AltaProcedimientoImpl();
		altaProcedimiento1.introducirDatosProcedimiento("0001",
				"rotura display usb",
				"conectores de la entrada del display del usb no funcionan");
		rpro.getProcedimiento("0001").setDadoDeBaja(true);

		AltaAsociacion alta = new AltaAsociacionImpl();
		alta.seleccionarTecnico("currito");

		Set<String> setId = new HashSet<String>();
		setId.add("0000");
		alta.asignarProcedimientos(setId);

		Tecnico t = rt.getTecnico("currito");
		System.out.println("Procedimientos de " + t + " : "
				+ t.getProcedimientos());

		BajaAsociacion baja = new BajaAsociacionImpl();

		baja.seleccionaTecnico("currito");
		System.out.println("Procedimientos del sistema "
				+ baja.listarProcedimientos());
		Set<Procedimiento> set = new HashSet<Procedimiento>();
		set.add(rpro.getProcedimiento("0000"));

		System.out.println("Procedimiento a eliminar " + set);
		baja.desasociarProcedimientos(set);
		System.out.println("tecnicos del sistema " + baja.listarTecnicos()
				+ " tecnicos activos" + baja.listarTecnicosActivos());
		System.out
				.println("procedimientos del tecnico" + t.getProcedimientos());

		AltaProducto p = new AltaProductoImpl();
		p.datosProducto("132", "test", "pfff");
		Set<String> setProcedimientos = new HashSet<String>();
		setProcedimientos.add(rpro.getProcedimiento("0001").getCodigo());
		System.out.println(setProcedimientos);
		p.seleccionarProcedimientos(setProcedimientos);
		p.registrarProducto();
		System.out.println("productos: " + rp.getProductos());
		System.out.println("Procedimientos -->"
				+ rp.getProducto("132").getProcedimientos());
		System.out.println(p.listarProcedimientosDadosDeAlta());
		System.out.println("productos dados de alta "
				+ rp.getProductosDadosDeAlta());
		rp.getProducto("132").setDadoDeBaja(true);
		System.out.println("productos dados de alta "
				+ rp.getProductosDadosDeAlta());

	}
}
