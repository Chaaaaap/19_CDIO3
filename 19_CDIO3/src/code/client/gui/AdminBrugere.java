package code.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;



public class AdminBrugere extends Composite {
	
	
	private MainMenu menu;
	private MainView main;
	private FlexTable fTable = new FlexTable();
	private Button opret;
	private Button opdater;
	private Button tilbage;
	private Button deaktiver;
	
	public AdminBrugere(MainView main, MainMenu menu) {
		initWidget(fTable);
		this.main = main;
		this.menu = menu;
		
		opret = new Button("Opret ny bruger");
		opret.setWidth("150px");
		deaktiver = new Button("Deaktiver bruger");
		deaktiver.setWidth("150px");
		opdater = new Button("Opdater bruger");
		opdater.setWidth("150px");
		tilbage = new Button("Tilbage til hovedmenu");
		tilbage.setWidth("150px");

		opret.addClickHandler(new OpretBrugerHandler());
		deaktiver.addClickHandler(new DeaktiverBrugerHandler());
		opdater.addClickHandler(new OpdaterBrugerHandler());
		tilbage.addClickHandler(new TilbageHandler());
		
		fTable.setWidget(0, 0, opret);
		fTable.setWidget(0, 1, deaktiver);
		fTable.setWidget(0, 2, opdater);
		fTable.setWidget(0, 3, tilbage);
		
	}
	
	
	private class OpretBrugerHandler implements ClickHandler {

		
		@Override
		public void onClick(ClickEvent event) {
			
			
			
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
			Button btn = new Button("Opret bruger!");	
			btn.setWidth("130px");
			
			
			fTable.setWidget(1, 0, lbl);
			fTable.setWidget(2, 0, txt);
			fTable.setWidget(3, 0, lbl1);
			fTable.setWidget(4, 0, txt1);
			fTable.setWidget(5, 0, lbl2);
			fTable.setWidget(6, 0, txt2);
			fTable.setWidget(7, 0, lbl3);
			fTable.setWidget(8, 0, txt3);
			fTable.setWidget(9, 0, lbl4);
			fTable.setWidget(10, 0, pTxt);
			fTable.setWidget(11, 0, lbl5);
			fTable.setWidget(12, 0, pTxt1);
			fTable.setWidget(14, 0, btn);
			
			
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
			
			
			main.clearMain();
			menu.setButtonsVisible();
			
		}
		
	}
	
	
}
