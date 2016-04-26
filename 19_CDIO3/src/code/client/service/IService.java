package code.client.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import code.client.dal.IOperatoerDAO.DALException;
import code.client.dal.OperatoerDTO;

@RemoteServiceRelativePath("cdio3")
public interface IService extends RemoteService {
	
	public void createUser() throws DALException, SQLException;
	public void editUser() throws DALException, SQLException;
	public void deactivateUser() throws DALException, SQLException;
	public void activateUser() throws DALException, SQLException;
	public OperatoerDTO getOperatoer(int oprID) throws DALException, SQLException;
	public ArrayList<OperatoerDTO> getOperatoerer() throws DALException, SQLException;
	
}
