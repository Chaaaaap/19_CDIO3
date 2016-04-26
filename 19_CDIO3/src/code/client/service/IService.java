package code.client.service;

import java.sql.SQLException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import code.client.dal.OperatoerDTO;
import code.client.dal.IOperatoerDAO.DALException;

@RemoteServiceRelativePath("cdio3")
public interface IService extends RemoteService {
	
	public void createUser();
	public void editUser();
	public void deactivateUser();
	public void activateUser();
	public OperatoerDTO getOperatoer(int oprID) throws DALException, SQLException;
	
}
