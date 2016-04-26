package code.client.service;

import java.sql.SQLException;

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
	
	public void createUser(AsyncCallback callback);
	public void editUser(AsyncCallback callback);
	public void deactivateUser(AsyncCallback callback);
	public void activateUser(AsyncCallback callback);
	public void getOperatoer(int oprID, AsyncCallback callback) throws DALException, SQLException;
	
	
	
	
	
	

}
