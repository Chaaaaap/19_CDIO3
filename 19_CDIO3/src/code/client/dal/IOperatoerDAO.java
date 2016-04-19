package code.client.dal;

import java.util.ArrayList;

public interface IOperatoerDAO {

	public ArrayList<OperatoerDTO> getOperatoerer();
	public void addPerson(OperatoerDTO user);
	public void deactivatePerson(int oprID);
	public void editPerson();
	public void showPerson();
}
