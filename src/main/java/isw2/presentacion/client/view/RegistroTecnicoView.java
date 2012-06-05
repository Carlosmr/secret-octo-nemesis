package isw2.presentacion.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import isw2.presentacion.client.presenter.RegistroTecnicoPresenter;

public class RegistroTecnicoView extends Composite implements
		RegistroTecnicoPresenter.Display {
	private VerticalPanel formulario = new VerticalPanel();
	private HorizontalPanel panel_user = new HorizontalPanel();
	private Label label_user = new Label();
	private TextBox user = new TextBox();
	private HorizontalPanel panel_password = new HorizontalPanel();
	private Label label_password = new Label();
	private PasswordTextBox password = new PasswordTextBox();
	private Button registrar = new Button("Registrar");

	public RegistroTecnicoView() {
		label_user.setText("Usuario:");
		label_password.setText("Contraseña:");

		panel_user.add(label_user);
		panel_user.add(user);

		panel_password.add(label_password);
		panel_password.add(password);

		formulario.add(panel_user);
		formulario.add(panel_password);
		formulario.add(registrar);
		RootPanel.get().add(formulario);
	}

	@Override
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

}
