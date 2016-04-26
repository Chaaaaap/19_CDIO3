package code.client.dal;

import java.sql.SQLException;
import java.util.ArrayList;



public class OperatoerDAO implements IOperatoerDAO {
	
	private ArrayList<OperatoerDTO> oprList;
	
	public OperatoerDAO() {
		oprList = new ArrayList<OperatoerDTO>();
		oprList.add(new OperatoerDTO(10, "Martin", "MA", "1901231685", "Test1234", true));
		oprList.add(new OperatoerDTO(11, "Frank", "FR", "1907922682", "Test1234", false));
		oprList.add(new OperatoerDTO(12, "Silas", "SL", "1907921245", "Test1234", false));
	}
	
	public void addPerson(OperatoerDTO user) throws DALException{
		oprList.add(user);
	}

	@Override
	public void deactivatePerson(int oprID) throws DALException{
		for (OperatoerDTO operatoerDTO : oprList) {
			if(operatoerDTO.getOprID() == oprID) {
				operatoerDTO.deactivate();
			}
		}
	}

	@Override
	public void editPerson() throws DALException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPerson() throws DALException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OperatoerDTO> getOperatoerer() throws DALException{
		return oprList;
	}

}
