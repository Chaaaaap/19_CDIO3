package code.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

public class MainView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel = new VerticalPanel();
	private OperatoerDAO oprDAO;
	private ArrayList<OperatoerDTO> oprList;
	
	public MainView(OperatoerDAO operatoerDAO) {
		initWidget(vPanel);
		oprDAO = operatoerDAO;
		MainMenu menu = new MainMenu(this, oprDAO);
		vPanel.add(menu);
		
		Login login = new Login(this, oprDAO, menu);
		contentPanel.add(login);
		vPanel.add(contentPanel);
	}
	
	public MainView() {
		initWidget(vPanel);
		oprDAO = new OperatoerDAO();
		oprList = oprDAO.getOperatoerer();
		MainMenu menu = new MainMenu(this, oprDAO);
		vPanel.add(menu);
		
		Login login = new Login(this, oprDAO, menu);
		contentPanel.add(login);
		vPanel.add(contentPanel);
	}
	
	public void clearMain() {
		this.contentPanel.clear();
	}
	
	public void openAfvejning() {
		
		contentPanel.clear();
		Afvej afvej = new Afvej();
		contentPanel.add(afvej);
	}

	public void attach(Widget widget) {
		contentPanel.add(widget);
	}
}
