package code.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import code.client.dal.OperatoerDAO;

public class MainMenu extends Composite {

	private HorizontalPanel hPanel = new HorizontalPanel();
	private MainView main;
	private Button afvej;
	private Button skiftPassword;
	private Button administrerBrugere;
	private Button logout;
	
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

		afvej = new Button("Afvej");
		skiftPassword = new Button("Skift password");
		administrerBrugere = new Button("Administrer brugere");
		logout = new Button("Log ud");

		afvej.addClickHandler(new AfvejHandler(this.main));
		afvej.setVisible(false);
		skiftPassword.addClickHandler(new PasswordHandler(this.main));
		skiftPassword.setVisible(false);
		administrerBrugere.addClickHandler(new AdministrerBrugere(this.main));
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

		public PasswordHandler(MainView main) {
			this.main = main;
		}
		@Override
		public void onClick(ClickEvent event) {
			main.clearMain();
			SkiftPassword skiftPass = new SkiftPassword();
			main.attach(skiftPass);
		}

	}

	private class AdministrerBrugere implements ClickHandler {

		private MainView main;

		public AdministrerBrugere(MainView main) {
			this.main = main;
		}
		@Override
		public void onClick(ClickEvent event) {
			main.clearMain();
			AdminBrugere adminBrugere = new AdminBrugere();
			main.attach(adminBrugere);
		}

	}
	
	private class LogoutHandler implements ClickHandler {

		private MainView main;
		private OperatoerDAO oprDAO;
		private MainMenu menu;
		
		public LogoutHandler(MainView main, OperatoerDAO oprDAO, MainMenu menu) {
			this.main = main;
			this.oprDAO = oprDAO;
			this.menu = menu;
		}
		@Override
		public void onClick(ClickEvent event) {
			main.clearMain();
			Login login = new Login(main, oprDAO, menu);
			main.attach(login);
			menu.setButtonsInvisible();
		}
		
	}
	
}






