package code.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class _9_CDIO3 implements EntryPoint {
	
	private	MainView mainView;
//	private OperatoerDAO operatoerDAO;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		mainView = new MainView();
		
		RootPanel.get().add(mainView);
	}
}
