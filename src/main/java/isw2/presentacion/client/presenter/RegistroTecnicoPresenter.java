package isw2.presentacion.client.presenter;

import java.util.Date;

import isw2.presentacion.client.AltaTecnico;
import isw2.presentacion.client.AltaTecnicoAsync;
import isw2.presentacion.client.RegistroTecnicoServiceAsync;
import isw2.presentacion.client.view.RegistroTecnicoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.rpc.client.RpcService;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class RegistroTecnicoPresenter implements Presenter {
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

	public RegistroTecnicoPresenter(HandlerManager eventBus) {
		this.rpcService = GWT.create(AltaTecnico.class);
		this.display = new RegistroTecnicoView();
	}

	public void bind() {
		display.getRegistro().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				registroTecnico();
			}
		});
	}

	protected void registroTecnico() {
		rpcService.introducirCredenciales(display.getUser(), display.getPassword(), new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable arg0) {
				Window.alert("FAIL1");
			}

			@Override
			public void onSuccess(Void arg0) {
				Window.alert("OK1");	
			}
		});
		rpcService.introducirDatosPersonales(display.getNombre(), display.getApellidos(), display.getFechaNac(), display.getDireccion(), display.getTelefono(), new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable arg0) {
				Window.alert("FAIL2");				
			}

			@Override
			public void onSuccess(Void arg0) {
				Window.alert("OK2");
			}});
		rpcService.registrarTecnico(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable arg0) {
				Window.alert("FAIL3");				
			}

			@Override
			public void onSuccess(Void arg0) {
				Window.alert("OK3");				
			}
		});
		
	}

	public void go(HasWidgets container) {
		bind();
		// container.clear();
		// container.add(display.asWidget());
	}

}