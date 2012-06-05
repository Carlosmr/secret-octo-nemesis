package isw2.presentacion.client.presenter;

import isw2.presentacion.client.RegistroTecnicoService;
import isw2.presentacion.client.RegistroTecnicoServiceAsync;
import isw2.presentacion.client.view.RegistroTecnicoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class RegistroTecnicoPresenter implements Presenter {
	private final Display display;
	private RegistroTecnicoServiceAsync rpcService;

	public interface Display {
		Widget asWidget();

		HasClickHandlers getRegistro();

		String getUser();

		String getPassword();
	}

	public RegistroTecnicoPresenter(HandlerManager eventBus,
			RegistroTecnicoView registroTecnicoView) {
		this.rpcService = GWT.create(RegistroTecnicoService.class);
		this.display = registroTecnicoView;
	}

	public void bind() {
		display.getRegistro().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				registroTecnico();
			}
		});
	}

	protected void registroTecnico() {
		Window.alert("AY oma, que bien va esto");
		rpcService.registrar(display.getUser(), display.getPassword(),
				new AsyncCallback<Boolean>() {
					public void onSuccess(Boolean result) {
						if (result) {
							Window.alert("Todo ha ido canelita.");
						} else {
							Window.alert("Ay niño, que esto ha pegao un petardo.");
						}
					}

					public void onFailure(Throwable caught) {
						Window.alert("Petardazo en (" + caught.getMessage()
								+ ")");
					}
				});
	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

}