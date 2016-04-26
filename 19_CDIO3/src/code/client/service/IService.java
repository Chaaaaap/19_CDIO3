package code.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("cdio3")
public interface IService extends RemoteService {
	
	public void createUser();

	
}
