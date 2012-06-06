package isw2.presentacion.client.presenter;

import isw2.presentacion.client.view.AltaAsociacionView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AltaAsociacionPresenter implements Presenter {

	private final Display display;

	public interface Display {
		Widget asWidget();
	}

	public AltaAsociacionPresenter() {
		this.display = new AltaAsociacionView();
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub

	}

}
