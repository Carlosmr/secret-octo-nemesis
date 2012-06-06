package isw2.presentacion.client;

import isw2.presentacion.client.presenter.Presenter;
import isw2.presentacion.client.presenter.AltaTecnicoPresenter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.History;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private HasWidgets container;

	public AppController(HandlerManager eventBus) {
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("registro");
		} else {
			History.fireCurrentHistoryState();
		}

	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("registro")) {
				presenter = new AltaTecnicoPresenter(eventBus);
			}
			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

}