package isw2.servicio.tecnico;

import isw2.autentificacion.Autentificacion;

public class AutentificacionTecnico {

	private Autentificacion autentificacion;

	public AutentificacionTecnico(Autentificacion autentificacion) {
		this.autentificacion = autentificacion;
	}

	public Boolean logIn(String user, String password) {
		if (autentificacion.credencialesValidos(user, password)) {
//
//			HttpServletRequest request = this.getThreadLocalRequest();
//			request.getSession().setAttribute("session.user", user);

			return true;
		} else {
			return false;
		}

	}

	public Autentificacion getAutentificacion() {
		return autentificacion;
	}

	public void setAutentificacion(Autentificacion autentificacion) {
		this.autentificacion = autentificacion;
	}

}
