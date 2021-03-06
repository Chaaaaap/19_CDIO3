package code.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

public class MainMenu extends Composite {

	private HorizontalPanel hPanel = new HorizontalPanel();
	private MainView main;
	private Button afvej;
	private Button skiftPassword;
	private Button administrerBrugere;
	private Button logout;
	private MainMenu menu;

	//	public MainMenu(MainView main) {
	//
	//		initWidget(hPanel);
	//		this.main = main;
	//
	//		afvej = new Button("Afvej");
	//		skiftPassword = new Button("Skift password");
	//		administrerBrugere = new Button("Administrer brugere");
	//		logout = new Button("Log ud");
	//
	//		afvej.addClickHandler(new AfvejHandler(this.main));
	//		afvej.setVisible(false);
	//		skiftPassword.addClickHandler(new PasswordHandler(this.main));
	//		skiftPassword.setVisible(false);
	//		administrerBrugere.addClickHandler(new AdministrerBrugere(this.main));
	//		administrerBrugere.setVisible(false);
	//		logout.addClickHandler(new LogoutHandler(this.main, oprDAO, this));
	//		logout.setVisible(false);
	//
	//		hPanel.add(afvej);
	//		hPanel.add(skiftPassword);
	//		hPanel.add(administrerBrugere);
	//		hPanel.add(logout);
	//
	//	}

	public MainMenu(MainView main, OperatoerDAO oprDAO) {

		initWidget(hPanel);
		this.main = main;
		this.menu = this;

		afvej = new Button("Afvej");
		skiftPassword = new Button("Skift password");
		administrerBrugere = new Button("Administrer brugere");
		logout = new Button("Log ud");

		afvej.addClickHandler(new AfvejHandler(this.main));
		afvej.setVisible(false);
		skiftPassword.addClickHandler(new PasswordHandler(this.main, oprDAO));
		skiftPassword.setVisible(false);
		administrerBrugere.addClickHandler(new AdministrerBrugere(this.main, oprDAO));
		administrerBrugere.setVisible(false);
		logout.addClickHandler(new LogoutHandler(this.main, oprDAO, this));
		logout.setVisible(false);

		hPanel.add(afvej);
		hPanel.add(skiftPassword);
		hPanel.add(administrerBrugere);
		hPanel.add(logout);
	}
	public void setButtonsVisible() {
		afvej.setVisible(true);
		skiftPassword.setVisible(true);
		administrerBrugere.setVisible(true);
		logout.setVisible(true);
	}

	public void setButtonsInvisible() {
		afvej.setVisible(false);
		skiftPassword.setVisible(false);
		administrerBrugere.setVisible(false);
		logout.setVisible(false);
	}

	private class AfvejHandler implements ClickHandler {

		private MainView main;

		public AfvejHandler(MainView main) {
			this.main = main;
		}
		@Override
		public void onClick(ClickEvent event) {
			main.clearMain();
			Afvej afvej = new Afvej();
			main.attach(afvej);
		}

	}

	private class PasswordHandler implements ClickHandler {

		private MainView main;
		private OperatoerDAO oprDAO;

		public PasswordHandler(MainView main, OperatoerDAO oprDAO) {
			this.main = main;
			this.oprDAO = oprDAO;
		}
		@Override
		public void onClick(ClickEvent event) {
			main.clearMain();
			SkiftPassword skiftPass = new SkiftPassword(oprDAO);
			main.attach(skiftPass);
		}

	}

	private class AdministrerBrugere implements ClickHandler {

		private MainView main;
		private OperatoerDAO oprDAO;
		private OperatoerDTO opr;
		private ArrayList<OperatoerDTO> oprList;

		public AdministrerBrugere(MainView main, OperatoerDAO oprDAO){
			this.main = main;
			this.oprDAO = oprDAO;
			oprList = this.oprDAO.getOperatoerer();
		}
		@Override
		public void onClick(ClickEvent event) {

			
			
			for (OperatoerDTO opr : oprList) {
				if(opr.loggedIn())
					this.opr = opr;
			}
			if(opr.isAdmin()) {
				setButtonsInvisible();
				main.clearMain();
				AdminBrugere adminBrugere = new AdminBrugere(main, menu, oprDAO, opr);
				main.attach(adminBrugere);
			} else {
				Window.alert("Du skal være administrator eller superbruger for at komme herind.");
			}
		}

	}

	private class LogoutHandler implements ClickHandler {

		private MainView main;
		private OperatoerDAO oprDAO;
		private MainMenu menu;
		private ArrayList<OperatoerDTO> oprList;
		private OperatoerDTO opr;

		public LogoutHandler(MainView main, OperatoerDAO oprDAO, MainMenu menu) {
			this.main = main;
			this.oprDAO = oprDAO;
			this.menu = menu;
			oprList = oprDAO.getOperatoerer();
		}
		@Override
		public void onClick(ClickEvent event) {

			for (OperatoerDTO opr : oprList) {
				if(opr.loggedIn())
					this.opr = opr;
			}
			opr.logIn(false);
			main.clearMain();
			Login login;
			login = new Login(main, oprDAO, menu);
			main.attach(login);
			menu.setButtonsInvisible();
		}

	}

}






