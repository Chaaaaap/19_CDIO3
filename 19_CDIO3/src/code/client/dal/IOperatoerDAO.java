package code.client.dal;

import java.util.ArrayList;



public interface IOperatoerDAO {
	
	public class DALException extends Exception {
		/*********************************************
		 * Det serienummer den meget gerne ville have*
		 *********************************************/
		private static final long serialVersionUID = 2688110316107454903L;

		public DALException(String msg) {
			super(msg);
		}
	}
	
	public ArrayList<OperatoerDTO> getOperatoerer();
	public OperatoerDTO getOperatoer(int oprID); 
	public void addPerson(OperatoerDTO user);
	public void deactivatePerson(int oprID);
	public void activatePerson(int oprID);
	public void editPerson();
	public void showPerson();
}
