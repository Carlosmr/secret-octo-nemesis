package isw2.presentacion.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Acme implements EntryPoint {

	private HorizontalPanel formulario = new HorizontalPanel();
	private VerticalPanel panel_user = new VerticalPanel();
	private Label label_user = new Label();
	private TextBox user = new TextBox();
	private VerticalPanel panel_password = new VerticalPanel();
	private Label label_password = new Label();
	private PasswordTextBox password = new PasswordTextBox();
	private Button registrar = new Button("Registrar");

	public void onModuleLoad() {
		panel_user.add(label_user);
		panel_user.add(user);
		
		panel_password.add(label_password);
		panel_password.add(password);
		
		formulario.add(panel_user);
		formulario.add(panel_password);
		formulario.add(registrar);
		RootPanel.get("registro").add(formulario);
	}

}
