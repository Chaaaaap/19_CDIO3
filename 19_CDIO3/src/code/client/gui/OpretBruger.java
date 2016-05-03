package code.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.OperatoerDAO;

public class OpretBruger extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	
	public OpretBruger(MainView main, MainMenu menu, OperatoerDAO oprDAO) {
		initWidget(vPanel);

		
		
		Label lbl = new Label("Indtast operatør ID");
		TextBox txt = new TextBox();
		txt.setWidth("120px");
		Label lbl1 = new Label("Indtast navn");
		TextBox txt1 = new TextBox();
		txt1.setWidth("120px");
		Label lbl2 = new Label("Indtast initialer");
		TextBox txt2 = new TextBox();
		txt2.setWidth("120px");
		Label lbl3 = new Label("Indtast cpr-nummer");
		TextBox txt3 = new TextBox();
		txt3.setWidth("120px");
		Label lbl4 = new Label("Indtast nyt password");
		PasswordTextBox pTxt = new PasswordTextBox();
		pTxt.setWidth("120px");
		Label lbl5 = new Label("Gentag password");
		PasswordTextBox pTxt1 = new PasswordTextBox();
		pTxt1.setWidth("120px");
		Button btn = new Button("Opret bruger");
		btn.setWidth("130px");
		btn.addClickHandler(new OpretBrugerHandler());
		

		vPanel.add(lbl); 	
		vPanel.add(txt);
		vPanel.add(lbl1);	
		vPanel.add(txt1);
		vPanel.add(lbl2);	
		vPanel.add(txt2);
		vPanel.add(lbl3);	
		vPanel.add(txt3);
		vPanel.add(lbl4);	
		vPanel.add(pTxt);
		vPanel.add(lbl5);	
		vPanel.add(pTxt1);
		vPanel.add(btn);
		
		
		

	}
	
	private class OpretBrugerHandler implements ClickHandler {
	
		@Override
		public void onClick(ClickEvent event) {
			Window.alert("Fucking workssss");
			// Implement functionality for create user button

			//				int indtastetOprID = Integer.parseInt(txt.getText());
			//				
			//				if (oprDAO.getOperatoer() == indtastetOprID) {
			//					Window.alert("Dette ID nummer er allerede i brug!");
			//				}else 
			//					oprDTO.setOprID(indtastetOprID);
			
		}
		
	}

		
}
