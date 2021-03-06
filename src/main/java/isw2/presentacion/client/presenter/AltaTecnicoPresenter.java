package isw2.presentacion.client.presenter;

import java.util.Date;

import isw2.presentacion.client.AltaTecnico;
import isw2.presentacion.client.AltaTecnicoAsync;
import isw2.presentacion.client.view.AltaTecnicoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AltaTecnicoPresenter implements Presenter {
	private final Display display;
	private AltaTecnicoAsync rpcService;

	public interface Display {
		Widget asWidget();

		HasClickHandlers getRegistro();

		String getUser();

		String getPassword();

		String getNombre();

		String getApellidos();

		Date getFechaNac();

		String getDireccion();

		String getTelefono();
	}

	public AltaTecnicoPresenter(HandlerManager eventBus) {
		this.rpcService = GWT.create(AltaTecnico.class);
		this.display = new AltaTecnicoView();
	}

	public void bind() {
		display.getRegistro().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				registroTecnico();
			}
		});
	}

	protected void registroTecnico() {
		rpcService.registrarTecnico(display.getUser(), display.getPassword(),
				display.getNombre(), display.getApellidos(),
				display.getFechaNac(), display.getDireccion(),
				display.getTelefono(), new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable arg0) {
						Window.alert("Se ha producido un error al hacer la llamada al servidor.");
					}

					@Override
					public void onSuccess(Boolean arg0) {
						if (arg0)
							Window.alert("Registro correcto.");
						else
							Window.alert("El nombre de usuario ya se encuentra registrado.");
					}
				});
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}