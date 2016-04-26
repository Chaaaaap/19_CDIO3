package code.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import code.client.dal.IOperatoerDAO.DALException;
import code.client.service.ServiceClient;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class _9_CDIO3 implements EntryPoint {
	
	ServiceClient client;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		client = new ServiceClient();
		
		client.getMainView().getElement().setAttribute("align", "center");
		
		RootPanel.get().add(client.getMainView());
	}
}
