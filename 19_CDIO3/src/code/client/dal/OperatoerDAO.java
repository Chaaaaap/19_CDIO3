package code.client.dal;

import java.sql.SQLException;
import java.util.ArrayList;

import code.server.ServiceImpl;



public class OperatoerDAO implements IOperatoerDAO {
	
	private ArrayList<OperatoerDTO> oprList;
//	private ServiceImpl service;
	
	public OperatoerDAO() {
		oprList = new ArrayList<OperatoerDTO>();
//		service = new ServiceImpl();
		oprList.add(new OperatoerDTO(10, "Martin", "MA", "1901231685", "Test1234", true));
		oprList.add(new OperatoerDTO(11, "Frank", "FR", "1907922682", "Test1234", false));
		oprList.add(new OperatoerDTO(12, "Silas", "SL", "1907921245", "Test1234", false));
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
//		return service.getOperatoerer();
		return null;
	}
	
	@Override
	public OperatoerDTO getOperatoer(int oprID){
//		return service.getOperatoer(oprID);
		return null;
	}

}
