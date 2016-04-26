package code.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import code.client.dal.IOperatoerDAO.DALException;
import code.client.dal.OperatoerDTO;
import code.client.service.IService;
import code.connector.Connector;

public class ServiceImpl extends RemoteServiceServlet implements IService {

	private Connector con;

	public ServiceImpl() {
		con = new Connector();
	}

	@Override
	public void createUser() {
		
	}

	@Override
	public void editUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateUser() {
		// TODO Auto-generated method stub
		
	}
	
	public OperatoerDTO getOperatoer(int oprID) throws SQLException, DALException {
		ResultSet rs = con.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprID);
	    try {
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprID + " findes ikke");
	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), true);
	    }
	    catch (SQLException e) {throw new DALException(e.getMessage()); }
	}

	@Override
	public ArrayList<OperatoerDTO> getOperatoerer() throws DALException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
