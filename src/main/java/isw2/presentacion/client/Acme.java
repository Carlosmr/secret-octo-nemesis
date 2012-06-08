package isw2.presentacion.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class Acme implements EntryPoint {

	public void onModuleLoad() {
		HandlerManager eventBus = new HandlerManager(null);
		AppController a = new AppController(eventBus);
		a.go(RootPanel.get());

	}

}
