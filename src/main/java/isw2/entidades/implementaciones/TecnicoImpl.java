package isw2.entidades.implementaciones;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import isw2.entidades.contratos.Procedimiento;
import isw2.entidades.contratos.Tecnico;

@Entity
public class TecnicoImpl implements Tecnico{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6690842934791759879L;
	@Id
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String direccion;
	private String telefono;
	private Boolean dadoDeBaja;
	@ManyToMany
	private Set<Procedimiento> procedimientos;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TecnicoImpl other = (TecnicoImpl) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public TecnicoImpl(String user, String password, String nombre,
			String apellidos, Date fechaNacimiento, String direccion,
			String telefono) {

		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dadoDeBaja = false;
		this.procedimientos = new HashSet<Procedimiento>();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {

		if (user == null)
			throw new NullPointerException();

		else if (user.equals(""))
			throw new IllegalArgumentException();

		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		if (password == null)
			throw new NullPointerException();

		else if (password.length() <= 6)
			throw new IllegalArgumentException();

		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		if (nombre == null)
			throw new NullPointerException();

		else if (nombre.equals(""))
			throw new IllegalArgumentException();

		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {

		if (apellidos == null)
			throw new NullPointerException();
		else if (apellidos.equals(""))
			throw new IllegalArgumentException();

		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		if (fechaNacimiento == null)
			throw new NullPointerException();
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion == null)
			throw new NullPointerException();
		else if (direccion.equals(""))
			throw new IllegalArgumentException();

		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null)
			throw new NullPointerException();
		else if (!telefono.matches("\\d{9}(\\d{3})?"))
			throw new IllegalArgumentException();

		this.telefono = telefono;
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

		else if (getProcedimientos().size() >= 10
				|| procedimiento.getDadoDeBaja()
				|| getProcedimientos().contains(procedimiento))
			throw new IllegalArgumentException();

		procedimientos.add(procedimiento);
	}

	public void eliminaProcedimiento(Procedimiento procedimiento) {

		if (procedimiento == null)
			throw new NullPointerException();
		else if (!getProcedimientos().contains(procedimiento))
			throw new IllegalArgumentException();
		procedimientos.remove(procedimiento);
	}

}
