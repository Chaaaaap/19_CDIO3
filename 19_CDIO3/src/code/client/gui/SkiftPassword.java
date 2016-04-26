package code.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.IOperatoerDAO.DALException;
import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

public class SkiftPassword extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private PasswordTextBox pTxt1;
	private PasswordTextBox pTxt2;
	private PasswordTextBox pTxt3;
	private OperatoerDAO oprDAO;
	
	
	public SkiftPassword(OperatoerDAO oprDAO) {
		initWidget(vPanel);
		
		this.oprDAO = oprDAO;
		
		try {
		
		Label lbl1 = new Label("Indtast dit gamle password");
		pTxt1 = new PasswordTextBox();
		vPanel.add(lbl1);
		vPanel.add(pTxt1);
		
		Label lbl2 = new Label("Indtast dit nye password");
		pTxt2 = new PasswordTextBox();
		vPanel.add(lbl2);
		vPanel.add(pTxt2);
		
		Label lbl3 = new Label("Gentag dit nye password");
		pTxt3 = new PasswordTextBox();
		vPanel.add(lbl3);
		vPanel.add(pTxt3);
		
		Button skiftPassword = new Button("OK!");
		skiftPassword.addClickHandler(new SkiftPasswordHandler(this.oprDAO));
		vPanel.add(skiftPassword);
		} catch(DALException e) {
			Window.alert(e.getMessage());
		}
	}
	
	private class SkiftPasswordHandler implements ClickHandler {
		
		private OperatoerDTO opr;
		private ArrayList<OperatoerDTO> oprList;
		private OperatoerDAO oprDAO;
		
		public SkiftPasswordHandler(OperatoerDAO oprDAO) throws DALException {
			this.oprDAO = oprDAO;
			oprList = this.oprDAO.getOperatoerer();
		}

		@Override
		public void onClick(ClickEvent event) {
			String oldPassword = pTxt1.getText();
			String newPassword1 = pTxt2.getText();
			String newPassword2 = pTxt3.getText();
			
			for (OperatoerDTO opr : oprList) {
				if(opr.loggedIn())
					this.opr = opr;
			}
			
			try {
				if(opr.setPassword(newPassword1, newPassword2, oldPassword)) {
					Window.alert("Dit password er nu ændret.");
				}
				
			} catch(DALException e) {
				Window.alert(e.getMessage());
			}
		}
		
	}
}
