package code.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Afvej extends Composite {
	
	VerticalPanel vPanel = new VerticalPanel();
	
	public Afvej() {
		initWidget(vPanel);
		
		Label lbl = new Label("Der bliver ikke implementeret noget her.");
		vPanel.add(lbl);
	}

}
