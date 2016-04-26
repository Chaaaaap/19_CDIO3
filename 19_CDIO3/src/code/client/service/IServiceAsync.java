package code.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IServiceAsync {
	
	public class DefaultCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Object result) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void createUser(AsyncCallback callback);
	
	
	
	
	

}
