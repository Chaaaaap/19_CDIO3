package code.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import code.client.dal.IOperatoerDAO.DALException;
import code.client.gui.MainView;

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
		try {
			mainView = new MainView();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		RootPanel.get().add(mainView);
	}
}
