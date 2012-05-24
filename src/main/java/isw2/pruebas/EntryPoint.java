package isw2.pruebas;

import isw2.servicio.producto.AltaProducto;
import isw2.servicio.producto.AltaProductoImpl;
import isw2.servicio.tecnico.AltaTecnico;
import isw2.servicio.tecnico.AltaTecnicoImpl;

import java.util.Date;

public class EntryPoint {

	public static void main(String[] args) {

		 AltaTecnico a = new AltaTecnicoImpl();
		 a.introducirCredenciales("benito", "benito");
		 a.introducirDatosPersonales("benito", "benito", new Date(), "a",
		 "9");
		 a.registrarTecnico();
		AltaProducto p = new AltaProductoImpl();
		p.datosProducto("132", "test", "pfff");
		p.registrarProducto();
		AltaProducto p2 = new AltaProductoImpl();
		p.datosProducto("132", "tasest", "pfff");
		p.registrarProducto();
	}

}
