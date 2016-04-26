package code.client.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import code.client.dal.OperatoerDTO;

@RemoteServiceRelativePath("cdio3")
public interface IService extends RemoteService {
	
	public void createUser() throws SQLException;
	public void editUser() throws SQLException;
	public void deactivateUser() throws SQLException;
	public void activateUser() throws SQLException;
	public OperatoerDTO getOperatoer(int oprID) throws SQLException;
	public ArrayList<OperatoerDTO> getOperatoerer() throws SQLException;
	
}
