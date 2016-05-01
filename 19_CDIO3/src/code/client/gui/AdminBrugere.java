package code.client.gui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import code.client.dal.IOperatoerDAO;
import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;



public class AdminBrugere extends Composite {
	
	
	
	private OperatoerDAO oprDAO;
	private OperatoerDTO oprDTO;
	private MainMenu menu;
	private MainView main;
	private FlexTable fTable = new FlexTable();
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
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
			
			vPanel.clear();
			
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
			Label lbl6 = new Label("Administrator");
			CheckBox admin = new CheckBox();
			
			Button btn = new Button("Opret bruger!");
			btn.setWidth("130px");
			btn.addClickHandler(new ClickHandler() {
					
				@Override
				public void onClick(ClickEvent event) {
					// Implement functionality for create user button	
				}
			});
			
			
			
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
			hPanel.add(lbl6);
			hPanel.add(admin);
			vPanel.add(btn);
			
			
			
			fTable.setWidget(1, 0, vPanel);
			vPanel.add(hPanel);
		}	
		
	}
	
	private class DeaktiverBrugerHandler implements ClickHandler {

//		FlexTable t;
//		HorizontalPanel hPanel = new HorizontalPanel();
		
		@Override
		public void onClick(ClickEvent event) {
			vPanel.clear();
			
			
//			t = new FlexTable();
//			
//			List<OperatoerDTO> personer = oprDAO.getOperatoerer();
//
//			for (int i=0; i < personer.size(); i++) {
//				t.setText(i+1, 0, personer.get(i).getOprNavn());
//			}
//
//			
//			hPanel.add(t);

//			fTable.setWidget(1, 1, hPanel);
		}
		
	}
	
	private class OpdaterBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
			
			vPanel.clear();
			
			
			Label lbl = new Label("Test");
			
			
			vPanel.add(lbl);
			
			
			
			fTable.setWidget(1, 2, vPanel);
			
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
