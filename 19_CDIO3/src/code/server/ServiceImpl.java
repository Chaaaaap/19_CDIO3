package code.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import code.client.dal.OperatoerDTO;
import code.client.service.IService;
import code.connector.Connector;

public class ServiceImpl extends RemoteServiceServlet implements IService {

//	private Connector con;

//	public ServiceImpl() {
//		con = new Connector();
//	}

	@Override
	public void createUser() {
		
	}

	@Override
	public void editUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateUser() {
		// TODO Auto-generated method stub
		
	}
	
	public OperatoerDTO getOperatoer(int oprID) {
		return null;
	}

	@Override
	public ArrayList<OperatoerDTO> getOperatoerer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
