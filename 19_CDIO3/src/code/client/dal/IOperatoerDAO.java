package code.client.dal;

import java.sql.SQLException;
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
	
	public ArrayList<OperatoerDTO> getOperatoerer() throws DALException;
	public OperatoerDTO getOperatoer(int oprID) throws DALException, SQLException;
	public void addPerson(OperatoerDTO user) throws DALException;
	public void deactivatePerson(int oprID) throws DALException;
	public void editPerson() throws DALException;
	public void showPerson() throws DALException;
}
