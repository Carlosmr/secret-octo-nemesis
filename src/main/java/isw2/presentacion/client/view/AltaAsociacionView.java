package isw2.presentacion.client.view;

import java.util.Set;

import isw2.presentacion.client.presenter.AltaAsociacionPresenter;
import isw2.presentacion.shared.Tecnico;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AltaAsociacionView extends Composite implements
		AltaAsociacionPresenter.Display {
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable tablaTecnicos = new FlexTable();
	private Tecnico tecnico;
	private Label label_tecnico = new Label();

	public AltaAsociacionView() {
		tablaTecnicos.setText(0, 0, "Usuario");
		tablaTecnicos.setText(0, 1, "Nombre");
		tablaTecnicos.setText(0, 2, "Apellidos");
		tablaTecnicos.setText(0, 3, "Seleccionar");
		mainPanel.add(label_tecnico);
		mainPanel.add(tablaTecnicos);
		initWidget(mainPanel);

	}

	public Widget asWidget() {
		return this;
	}

	public void setTecnicos(Set<Tecnico> arg0) {
		for (Tecnico e : arg0)
			addTecnico(e);
	}

	private void addTecnico(Tecnico e) {
		final Tecnico t = e;
		Button button = new Button("o");
		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent arg0) {
				tecnico = t;
				actualizaTablaProcedimientos();
			}
		});
		int row = tablaTecnicos.getRowCount();
		tablaTecnicos.setText(row, 0, e.getUser());
		tablaTecnicos.setText(row, 1, e.getNombre());
		tablaTecnicos.setText(row, 2, e.getApellidos());
		tablaTecnicos.setWidget(row, 3, button);
	}

	protected void actualizaTablaProcedimientos() {
		label_tecnico.setText(tecnico.getUser());
	}
}
