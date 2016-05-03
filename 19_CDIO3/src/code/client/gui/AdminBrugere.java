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

		opret.addClickHandler(new OpretBrugerHandler());
		deaktiver.addClickHandler(new DeaktiverBrugerHandler(oprDAO));
		opdater.addClickHandler(new OpdaterBrugerHandler(oprDAO));
		tilbage.addClickHandler(new TilbageHandler());

		fTable.setWidget(0, 0, opret);
		fTable.setWidget(0, 1, deaktiver);
		fTable.setWidget(0, 2, opdater);
		fTable.setWidget(0, 3, tilbage);

	}


	private class OpretBrugerHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			OpdaterBruger opdater = new OpdaterBruger(main, menu, oprDAO);
			fTable.setWidget(1, 0, opdater);

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

			vPanel.clear();
			hPanel.clear();


			DeaktiverBruger deaktiver = new DeaktiverBruger(main, menu, oprDAO);
			fTable.setWidget(1, 1, deaktiver);

		}

	}

	private class OpdaterBrugerHandler implements ClickHandler {

		private OperatoerDAO oprDAO;

		public OpdaterBrugerHandler(OperatoerDAO oprDAO) {
			this.oprDAO = oprDAO;
		}


		@Override
		public void onClick(ClickEvent event) {

			OpretBruger opret = new OpretBruger(main, menu, oprDAO);
			fTable.setWidget(1, 2, opret);

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
