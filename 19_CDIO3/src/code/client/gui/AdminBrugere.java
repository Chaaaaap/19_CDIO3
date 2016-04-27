package code.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;



public class AdminBrugere extends Composite {
	
	
	
	FlexTable fTable = new FlexTable();
	private Button opret;
	private Button opdater;
	private Button tilbage;
	private Button deaktiver;
	
	public AdminBrugere() {
		initWidget(fTable);
		
		opret = new Button("Opret ny bruger");
		deaktiver = new Button("Deaktiver bruger");
		opdater = new Button("Opdater bruger");
		tilbage = new Button("Tilbage til hovedmenu");

		opret.addClickHandler(new OpretBrugerHandler());
		deaktiver.addClickHandler(new DeaktiverBrugerHandler());
		opdater.addClickHandler(new OpdaterBrugerHandler());
		tilbage.addClickHandler(new TilbageHandler());
		
		fTable.setWidget(0, 0, opret);
		fTable.setWidget(0, 1, deaktiver);
		fTable.setWidget(0, 2, opdater);
		fTable.setWidget(0, 3, tilbage);
		
	}
	
	public void setButtonsVisible() {
		opret.setVisible(true);
		deaktiver.setVisible(true);
		opdater.setVisible(true);
		tilbage.setVisible(true);
	}

	public void setButtonsInvisible() {
		opret.setVisible(false);
		deaktiver.setVisible(false);
		opdater.setVisible(false);
		tilbage.setVisible(false);
	}

	
	private class OpretBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class DeaktiverBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class OpdaterBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
			
		}
		
	}
	
	private class TilbageHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
			setButtonsInvisible();
			
			
		}
		
	}
	
}
