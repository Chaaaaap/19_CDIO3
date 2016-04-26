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
		try {
			client = new ServiceClient();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		RootPanel.get().add(client.getMainView());
	}
}
