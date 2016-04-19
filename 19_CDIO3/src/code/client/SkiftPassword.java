package code.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SkiftPassword extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	PasswordTextBox pTxt1;
	PasswordTextBox pTxt2;
	PasswordTextBox pTxt3;
	
	
	public SkiftPassword() {
		initWidget(vPanel);
		
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
		skiftPassword.addClickHandler(new SkiftPasswordHandler());
		vPanel.add(skiftPassword);
	}
	
	private class SkiftPasswordHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String oldPassword = pTxt1.getText();
			String newPassword1 = pTxt2.getText();
			String newPassword2 = pTxt3.getText();
			
			if(newPassword1.equals(newPassword2) && oldPassword.equals("")) {
				
			} else {
				Window.alert("Du har skrevet forkert i et af felterne.");
			}
		}
		
	}
}
