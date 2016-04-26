package code.client.service;

import code.client.dal.IOperatoerDAO.DALException;
import code.client.gui.MainView;

public class ServiceClient implements IServiceClient {

	MainView mainView;
	
	public ServiceClient() throws DALException {
		mainView = new MainView();
	}
	
	public MainView getMainView() {
		return mainView;
	}
}
