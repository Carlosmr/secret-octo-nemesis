package isw2.presentacion.client.view;

import java.util.Date;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

import isw2.presentacion.client.presenter.AltaTecnicoPresenter;

public class AltaTecnicoView extends Composite implements
		AltaTecnicoPresenter.Display {
	private VerticalPanel formulario = new VerticalPanel();
	private HorizontalPanel panel_user = new HorizontalPanel();
	private Label label_user = new Label();
	private TextBox user = new TextBox();
	private HorizontalPanel panel_password = new HorizontalPanel();
	private Label label_password = new Label();
	private PasswordTextBox password = new PasswordTextBox();
	private HorizontalPanel panel_nombre = new HorizontalPanel();
	private Label label_nombre = new Label();
	private TextBox nombre = new TextBox();
	private HorizontalPanel panel_apellidos = new HorizontalPanel();
	private Label label_apellidos = new Label();
	private TextBox apellidos = new TextBox();
	private HorizontalPanel panel_direccion = new HorizontalPanel();
	private Label label_direccion = new Label();
	private TextBox direccion = new TextBox();
	private HorizontalPanel panel_telefono = new HorizontalPanel();
	private Label label_telefono = new Label();
	private TextBox telefono = new TextBox();
	private HorizontalPanel panel_fechaNac = new HorizontalPanel();
	private DatePicker fechaNac = new DatePicker();
	private Label label_fechaNac = new Label();

	private Button registrar = new Button("Registrar");

	public AltaTecnicoView() {
		label_user.setText("Usuario:");
		label_password.setText("Contraseña:");
		label_nombre.setText("Nombre:");
		label_apellidos.setText("Apellidos:");
		label_direccion.setText("Direccion:");
		label_telefono.setText("Telefono:");
		label_fechaNac.setText("Fecha Nacimiento:");

		panel_user.add(label_user);
		panel_user.add(user);

		panel_password.add(label_password);
		panel_password.add(password);

		panel_nombre.add(label_nombre);
		panel_nombre.add(nombre);

		panel_apellidos.add(label_apellidos);
		panel_apellidos.add(apellidos);

		panel_direccion.add(label_direccion);
		panel_direccion.add(direccion);

		panel_telefono.add(label_telefono);
		panel_telefono.add(telefono);

		panel_fechaNac.add(label_fechaNac);
		panel_fechaNac.add(fechaNac);

		formulario.add(panel_user);
		formulario.add(panel_password);
		formulario.add(panel_nombre);
		formulario.add(panel_apellidos);
		formulario.add(panel_fechaNac);
		formulario.add(panel_direccion);
		formulario.add(panel_telefono);
		formulario.add(registrar);
		initWidget(formulario);
	}

	public Widget asWidget() {
		return this;
	}

	public HasClickHandlers getRegistro() {
		return registrar;
	}

	@Override
	public String getUser() {
		return user.getText();
	}

	@Override
	public String getPassword() {
		return password.getText();
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getApellidos() {
		return apellidos.getText();
	}

	public Date getFechaNac() {
		return fechaNac.getValue();
	}

	public String getDireccion() {
		return direccion.getText();
	}

	public String getTelefono() {
		return telefono.getText();
	}

}
