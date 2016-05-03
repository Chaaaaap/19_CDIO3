package code.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;



public class AdminBrugere extends Composite {

	private MainMenu menu;
	private MainView main;
	private OperatoerDAO oprDAO;
	private OperatoerDTO oprDTO;
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	private Button opret;
	private Button opdater;
	private Button tilbage;
	private Button deaktiver;
	ArrayList<OperatoerDTO> oprList;

	public AdminBrugere(MainView main, MainMenu menu, OperatoerDAO oprDAO, OperatoerDTO oprDTO) {
		initWidget(hPanel);
		this.menu = menu;
		this.main = main;
		this.oprDAO = oprDAO;
		this.oprDTO = oprDTO;
		hPanel.setBorderWidth(1);

		opret = new Button("Opret ny bruger");
		opret.setWidth("150px");
		deaktiver = new Button("Deaktiver/Aktiver");
		deaktiver.setWidth("150px");
		opdater = new Button("Opdater bruger");
		opdater.setWidth("150px");
		tilbage = new Button("Tilbage til hovedmenu");
		tilbage.setWidth("150px");

		opret.addClickHandler(new OpretBrugerHandler());
		deaktiver.addClickHandler(new DeaktiverBrugerHandler());
		opdater.addClickHandler(new OpdaterBrugerHandler());
		tilbage.addClickHandler(new TilbageHandler());

		hPanel.add(opret);
		hPanel.add(deaktiver);
		hPanel.add(opdater);
		hPanel.add(tilbage);
	

	}


	private class OpretBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
			main.clearMain();
			
			AdminBrugere ab = new AdminBrugere(main, menu, oprDAO, oprDTO);
			main.attach(ab);
			
			OpretBruger ob = new OpretBruger(main, menu, oprDAO);
			main.attach(ob);
			

		}

	}

	private class DeaktiverBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.clearMain();
			
			AdminBrugere ab = new AdminBrugere(main, menu, oprDAO, oprDTO);
			main.attach(ab);
			
			
			DeaktiverBruger db = new DeaktiverBruger(oprDAO, oprDTO);
			main.attach(db);
			
//			OpretBruger ob = new OpretBruger(main, menu, oprDAO);
//			main.attach(ob);
					

		}

	}

	private class OpdaterBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
			main.clearMain();
			
			AdminBrugere ab = new AdminBrugere(main, null, null, oprDTO);
			main.attach(ab);

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

