package code.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

public class DeaktiverBruger extends Composite{

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

	
	public DeaktiverBruger(MainView main, MainMenu menu, OperatoerDAO oprDAO) {
		initWidget(fTable);
		this.main = main;
		this.menu = menu;
		this.oprDAO = oprDAO;
		oprList = this.oprDAO.getOperatoerer();
		
	
		vPanel.clear();
		hPanel.clear();
		ft.clear();
	
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
					
//					if(opr.getOprID() == 1) {
//						Window.alert("ID er 1");
//					}
//						opr.deactivate();
//					}else
//						Window.alert("Fejl");
					
//					Window.alert(opr.isActive()+"");
//					Window.alert(opr.getOprID()+"");
//					Window.alert(deaktiver.);
					
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
