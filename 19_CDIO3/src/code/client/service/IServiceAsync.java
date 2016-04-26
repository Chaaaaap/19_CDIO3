package code.client.service;

import java.sql.SQLException;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

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
	
	public void createUser(AsyncCallback callback) throws SQLException;
	public void editUser(AsyncCallback callback) throws SQLException;
	public void deactivateUser(AsyncCallback callback) throws SQLException;
	public void activateUser(AsyncCallback callback) throws SQLException;
	public void getOperatoer(int oprID, AsyncCallback callback) throws SQLException;
	public void getOperatoerer(AsyncCallback callback) throws SQLException;
	
	
	
	
	
	

}
