package code.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Authentication.User;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
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
	private FlexTable ft = new FlexTable();
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private Button opret;
	private Button opdater;
	private Button tilbage;
	private Button deaktiver;
	ArrayList<OperatoerDTO> oprList;

	public AdminBrugere(MainView main, MainMenu menu, OperatoerDAO oprDAO) {
		initWidget(fTable);
		this.main = main;
		this.menu = menu;
		this.oprDAO = oprDAO;

		opret = new Button("Opret ny bruger");
		opret.setWidth("150px");
		deaktiver = new Button("Deaktiver/Aktiver");
		deaktiver.setWidth("150px");
		opdater = new Button("Opdater bruger");
		opdater.setWidth("150px");
		tilbage = new Button("Tilbage til hovedmenu");
		tilbage.setWidth("150px");

		opret.addClickHandler(new OpretBrugerHandler(oprDAO));
		deaktiver.addClickHandler(new DeaktiverBrugerHandler(oprDAO));
		opdater.addClickHandler(new OpdaterBrugerHandler(oprDAO));
		tilbage.addClickHandler(new TilbageHandler());

		fTable.setWidget(0, 0, opret);
		fTable.setWidget(0, 1, deaktiver);
		fTable.setWidget(0, 2, opdater);
		fTable.setWidget(0, 3, tilbage);

	}


	private class OpretBrugerHandler implements ClickHandler {
		
		private OperatoerDTO opr;
		private ArrayList<OperatoerDTO> oprList;
		private OperatoerDAO oprDAO;

		public OpretBrugerHandler(OperatoerDAO oprDAO) {
			this.oprDAO = oprDAO;
			oprList = this.oprDAO.getOperatoerer();
		}
		
		@Override
		public void onClick(ClickEvent event) {

			
			ft.removeAllRows();
			vPanel.clear();
			hPanel.clear();
			
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
			btn.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// Implement functionality for create user button
					
//					int indtastetOprID = Integer.parseInt(txt.getText());
//					
//					if (oprDAO.getOperatoer() == indtastetOprID) {
//						Window.alert("Dette ID nummer er allerede i brug!");
//					}else 
//						oprDTO.setOprID(indtastetOprID);
					
					
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
			vPanel.add(btn);

			fTable.setWidget(1, 0, vPanel);

			


		}	

	}

	private class DeaktiverBrugerHandler implements ClickHandler {

		private OperatoerDTO opr;
		private ArrayList<OperatoerDTO> oprList;
		private OperatoerDAO oprDAO;
		
		public DeaktiverBrugerHandler(OperatoerDAO oprDAO) {
			this.oprDAO = oprDAO;
			oprList = this.oprDAO.getOperatoerer();
		}
		
		
		@Override
		public void onClick(ClickEvent event) {
			oprList = oprDAO.getOperatoerer();
			vPanel.clear();
			hPanel.clear();
		
			for (OperatoerDTO opr : oprList) {
				if(opr.loggedIn())
					this.opr = opr;
			}
			
			for (int i=0; i < oprList.size(); i++) {
				
				Button deaktiver = new Button("Deaktiver");
				deaktiver.getElement().setId(i+1+"");
				deaktiver.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// Hvad skal der ske når man deaktivere en person
						
//						if(opr.getOprID() == 1) {
//							Window.alert("ID er 1");
//						}
//							opr.deactivate();
//						}else
//							Window.alert("Fejl");
						
//						Window.alert(opr.isActive()+"");
//						Window.alert(opr.getOprID()+"");
//						Window.alert(deaktiver.);
						
					}
				});
				deaktiver.setWidth("80px");
				deaktiver.setHeight("30px");
				
				ft.setText(i, 0, oprList.get(i).getOprNavn());
				ft.setWidget(i, 1, deaktiver);
			}
	
			fTable.setWidget(1, 1, ft);
			
		}

	}

	private class OpdaterBrugerHandler implements ClickHandler {

		private OperatoerDAO oprDAO;
		
		public OpdaterBrugerHandler(OperatoerDAO oprDAO) {
			this.oprDAO = oprDAO;
		}
		
		
		@Override
		public void onClick(ClickEvent event) {
			oprList = oprDAO.getOperatoerer();
			vPanel.clear();
			hPanel.clear();
		
			
			
			for (int i=0; i < oprList.size(); i++) {
				
				Button opdater = new Button("Opdater");
				opdater.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						ft.removeAllRows();
						
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
						Button btn = new Button("Opdater!");
						btn.setWidth("130px");
						btn.addClickHandler(new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								// Implement functionality for update user button
								Window.alert("Hej");
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
						vPanel.add(btn);

						fTable.setWidget(1, 2, vPanel);
						
						
						
					}
				});
				opdater.setWidth("80px");
				opdater.setHeight("30px");
				
				ft.setText(i, 0, oprList.get(i).getOprNavn());
				ft.setWidget(i, 1, opdater);
			}
	
			fTable.setWidget(1, 2, ft);
			
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
