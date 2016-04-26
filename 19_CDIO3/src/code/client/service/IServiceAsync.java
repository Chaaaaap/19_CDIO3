package code.client.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import code.client.dal.OperatoerDTO;
import code.client.dal.IOperatoerDAO.DALException;

public interface IServiceAsync {
	
	@SuppressWarnings("rawtypes")
	public class DefaultCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert(caught.getMessage());
		}

		@Override
		public void onSuccess(Object result) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void createUser(AsyncCallback callback) throws DALException, SQLException;
	public void editUser(AsyncCallback callback) throws DALException, SQLException;
	public void deactivateUser(AsyncCallback callback) throws DALException, SQLException;
	public void activateUser(AsyncCallback callback) throws DALException, SQLException;
	public void getOperatoer(int oprID, AsyncCallback callback) throws DALException, SQLException;
	public void getOperatoerer(AsyncCallback callback) throws DALException, SQLException;
	
	
	
	
	
	

}
