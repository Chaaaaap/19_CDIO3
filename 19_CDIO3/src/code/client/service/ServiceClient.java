package code.client.service;

import code.client.gui.MainView;

public class ServiceClient implements IServiceClient {

	MainView mainView;
	
	public ServiceClient() {
		mainView = new MainView();
	}
	
	public MainView getMainView() {
		return mainView;
	}
}
