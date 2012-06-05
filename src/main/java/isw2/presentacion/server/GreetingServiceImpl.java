package isw2.presentacion.server;

import isw2.entidades.contratos.Tecnico;
import isw2.presentacion.client.GreetingService;
import isw2.servicio.tecnico.AltaTecnico;
import isw2.servicio.tecnico.AltaTecnicoImpl;
import isw2.servicio.tecnico.ModificacionTecnico;
import isw2.servicio.tecnico.ModificacionTecnicoImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// // Verify that the input is valid.
		// if (!FieldVerifier.isValidName(input)) {
		// // If the input is not valid, throw an IllegalArgumentException back
		// to
		// // the client.
		// throw new IllegalArgumentException(
		// "Name must be at least 4 characters long");
		// }
		//
		// String serverInfo = getServletContext().getServerInfo();
		// String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		//
		// // Escape data from the client to avoid cross-site script
		// vulnerabilities.
		// input = escapeHtml(input);
		// userAgent = escapeHtml(userAgent);
		//
		// return "Hello, " + input + "!<br><br>I am running " + serverInfo
		// + ".<br><br>It looks like you are using:<br>" + userAgent;
		// Tecnico t = new TecnicoImpl(input, input, input, input, new Date(),
		// input, input);
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("isw2.acme");
		// EntityManager em = emf.createEntityManager();
		// em.persist(t);
		// t=null;
		// t=em.find(TecnicoImpl.class,input);
		Tecnico t = null;
		AltaTecnico a = new AltaTecnicoImpl();
		a.introducirCredenciales(input, input);
		a.registrarTecnico();
		ModificacionTecnico b = new ModificacionTecnicoImpl();
		for (Tecnico r : b.listarTecnicos())
			t = r;
		return "Hola señor " + t.getUser().toString();

	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
