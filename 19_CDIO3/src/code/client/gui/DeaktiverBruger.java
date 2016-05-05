package code.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import code.client.dal.OperatoerDAO;
import code.client.dal.OperatoerDTO;

public class DeaktiverBruger extends Composite{

	private OperatoerDAO oprDAO;
	private OperatoerDTO oprDTO;
	private VerticalPanel vPanel = new VerticalPanel();
	private FlexTable t = new FlexTable();
	ArrayList<OperatoerDTO> oprList;
	Anchor previousCancel = null;

	public DeaktiverBruger(OperatoerDAO oprDAO, OperatoerDTO oprDTO) {
		initWidget(vPanel);
		vPanel.setBorderWidth(1);
		this.oprDAO = oprDAO;
		this.oprDTO = oprDTO;
		oprList = this.oprDAO.getOperatoerer();



		t = new FlexTable();
		t.getFlexCellFormatter().setWidth(0, 0, "130px");
		t.getFlexCellFormatter().setWidth(0, 1, "80px");
		t.getFlexCellFormatter().setWidth(0, 2, "80px");
		t.getFlexCellFormatter().setWidth(0, 3, "110px");

		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");

		// set headers in flextable
		t.setText(0, 0, "Navn");
		t.setText(0, 1, "ID");
		t.setText(0, 2, "Status");
		t.setText(0, 3, "Deaktiver/Aktiver");


		// populate table and add delete anchor to each row
		for (int i=0; i < oprList.size(); i++) {

			t.setText(i+1, 0, oprList.get(i).getOprNavn());
			t.setText(i+1, 1, "" + oprList.get(i).getOprID());

			Anchor deaktiver = new Anchor("deaktiver");
			deaktiver.addClickHandler(new DeaktiverHandler());
			Anchor aktiver = new Anchor("aktiver");
			aktiver.addClickHandler(new AktiverHandler());


			if(oprList.get(i).isActive()) {
				t.setText(i+1, 2, "Aktiv");
				t.setWidget(i+1, 3, deaktiver);

			}else {
				t.setText(i+1, 2, "Ikke aktiv");
				t.setWidget(i+1, 3, aktiver);	

			}
		}

		vPanel.add(t);


	}

	private class DeaktiverHandler implements ClickHandler {
		public void onClick(ClickEvent event) {




			// get rowindex where event happened
			final int eventRowIndex = t.getCellForEvent(event).getRowIndex();

			// get delete anchor ref for cancel operation
			final Anchor deaktiver =  (Anchor) event.getSource();


			final Anchor aktiver = new Anchor("aktiver");
			aktiver.addClickHandler(new AktiverHandler());


			if(eventRowIndex == oprDTO.getOprID()) {
				Window.alert("Du kan ikke deaktivere administratoren");
				t.setWidget(eventRowIndex, 3, deaktiver);
				t.clearCell(eventRowIndex, 4);
			}else {
				oprList.get(eventRowIndex-1).deactivate();
				t.setText(eventRowIndex, 2, "Ikke aktiv");
				t.setWidget(eventRowIndex, 3, aktiver);
				Window.alert("Din bruger er nu deaktiveret");
			}

		}

	}




	private class AktiverHandler implements ClickHandler {
		public void onClick(ClickEvent event) {


			// get rowindex where event happened
			final int eventRowIndex = t.getCellForEvent(event).getRowIndex();


			final Anchor deaktiver = new Anchor("deaktiver");
			deaktiver.addClickHandler(new DeaktiverHandler());


			oprList.get(eventRowIndex-1).activatePerson();
			t.setText(eventRowIndex, 2, "Aktiv");
			t.setWidget(eventRowIndex, 3, deaktiver);

			Window.alert("Din bruger er nu aktiv!");

		}

	}

}



