package isw2.presentacion.client.presenter;

import java.util.Set;

import isw2.presentacion.client.AltaAsociacion;
import isw2.presentacion.client.AltaAsociacionAsync;
import isw2.presentacion.client.view.AltaAsociacionView;
import isw2.presentacion.shared.Tecnico;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AltaAsociacionPresenter implements Presenter {

	private final Display display;
	private AltaAsociacionAsync rpcService;

	public interface Display {
		Widget asWidget();

		void setTecnicos(Set<Tecnico> arg0);
	}

	public AltaAsociacionPresenter() {
		this.display = new AltaAsociacionView();
		this.rpcService = GWT.create(AltaAsociacion.class);
		obtenerTecnicos();
	}

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());

	}

	public void obtenerTecnicos() {
		rpcService.listarTecnicosRegistrados(new AsyncCallback<Set<Tecnico>>() {
			@Override
			public void onSuccess(Set<Tecnico> arg0) {
				display.setTecnicos(arg0);
			}

			@Override
			public void onFailure(Throwable arg0) {
				Window.alert("No se han podido obtener los técnicos.");
			}
		});

	}

	private void bind() {
		// TODO Auto-generated method stub

	}

}
