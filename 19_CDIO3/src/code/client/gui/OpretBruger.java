package code.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

public class OpretBruger extends Composite {

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
	private OperatoerDTO opr;
	
	public OpretBruger(MainView main, MainMenu menu, OperatoerDAO oprDAO) {
		initWidget(fTable);
		this.main = main;
		this.menu = menu;
		this.oprDAO = oprDAO;
		oprList = this.oprDAO.getOperatoerer();
		
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