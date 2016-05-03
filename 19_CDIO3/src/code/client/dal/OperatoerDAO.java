package code.client.dal;

import java.util.ArrayList;

public class OperatoerDAO implements IOperatoerDAO {
	
	private ArrayList<OperatoerDTO> oprList;
	
	public OperatoerDAO() {
		oprList = new ArrayList<OperatoerDTO>();
		oprList.add(new OperatoerDTO(1, "Martin", "MA", "1901231685", "Test1234", true));
		oprList.add(new OperatoerDTO(2, "Frank", "FR", "1907922682", "Test1234", false));
		oprList.add(new OperatoerDTO(3, "Silas", "SL", "1907921245", "Test1234", false));
		oprList.add(new OperatoerDTO(4, "Ramyar", "RA", "1907921245", "Test1234", false));
		oprList.add(new OperatoerDTO(5, "Hans", "HA", "1907921245", "Test1234", false));
	}
	
	public void addPerson(OperatoerDTO user) {
		oprList.add(user);
	}

	@Override
	public void deactivatePerson(int oprID) {
		for (OperatoerDTO operatoerDTO : oprList) {
			if(operatoerDTO.getOprID() == oprID) {
				operatoerDTO.deactivate();
			}
		}
	}

	@Override
	public void editPerson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPerson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OperatoerDTO> getOperatoerer() {
		return oprList;
	}
	
	@Override
	public OperatoerDTO getOperatoer(int oprID){
		return null;
	}

}
