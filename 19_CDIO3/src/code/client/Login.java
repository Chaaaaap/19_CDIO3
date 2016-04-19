package code.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

//Navnet skal ændres senere
public class Login extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private HorizontalPanel hPanel2 = new HorizontalPanel();
	private PasswordTextBox pTxt;
	private TextBox txt;
	private MainView main;
	private MainMenu menu;

	public Login(MainView main, OperatoerDAO oprDAO, MainMenu menu) {
		initWidget(vPanel);
		this.main = main;
		this.menu = menu;

		txt = new TextBox();
		txt.setWidth("150px");
		hPanel.add(txt);
		Label lbl1 = new Label("Indtast operatør ID");
		hPanel.add(lbl1);
		pTxt = new PasswordTextBox();
		pTxt.setWidth("150px");
		hPanel2.add(pTxt);
		Label lbl2 = new Label("Indtast adgangskode");
		hPanel2.add(lbl2);
		vPanel.add(hPanel);
		vPanel.add(hPanel2);
		Button btn1 = new Button("Login");
		vPanel.add(btn1);

		btn1.addClickHandler(new ClickHandlerImplementation(this.main, oprDAO, menu));
	}

	private final class ClickHandlerImplementation implements ClickHandler {
		
		private MainView main;
		private OperatoerDAO oprDAO;
		private OperatoerDTO oprDTO;
		
		public ClickHandlerImplementation(MainView main, OperatoerDAO oprDAO, MainMenu menu) {
			this.main = main;
			this.oprDAO = oprDAO;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			String userName = txt.getText();
			String passwordEntered = pTxt.getText();
			String passwordReal = "";
			ArrayList<OperatoerDTO> oprList = oprDAO.getOperatoerer();
			
			
			for (OperatoerDTO operatoerDTO : oprList) {
				if(operatoerDTO.getOprID() == Integer.parseInt(userName)) {
					oprDTO = operatoerDTO;
					passwordReal = operatoerDTO.getPassword();
				}
			}
			if(passwordEntered.equals(passwordReal)) {
				if(oprDTO.isActive()) {
				oprDTO.logIn();
				menu.setButtonsVisible();
				this.main.clearMain();
				} else {
					Window.alert("Din bruger er deaktiveret!");
				}
				
			} else {
				Window.alert("Operatør ID og adgangskode passer ikke sammen!");
			}
		}
	}
}
