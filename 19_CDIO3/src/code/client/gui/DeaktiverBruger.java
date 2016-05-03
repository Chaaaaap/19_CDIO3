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

		t.addStyleName("FlexTable");
		t.getRowFormatter().addStyleName(0,"FlexTable-Header");

		// set headers in flextable
		t.setText(0, 0, "Navn");
		t.setText(0, 1, "ID");
		t.setText(0, 2, "Status");


		// populate table and add delete anchor to each row
		for (int i=0; i < oprList.size(); i++) {
			
			t.setText(i+1, 0, oprList.get(i).getOprNavn());
			t.setText(i+1, 1, "" + oprList.get(i).getOprID());

			if(oprList.get(i).isActive()) {
				t.setText(i+1, 2, "Aktiv");
				Anchor deaktiver = new Anchor("deaktiver");
				t.setWidget(i+1, 3, deaktiver);
				deaktiver.addClickHandler(new DeaktiverHandler());
			}else {
				t.setText(i+1, 2, "Ikke aktiv");
				Anchor aktiver = new Anchor("aktiver");
				t.setWidget(i+1, 3, aktiver);
				aktiver.addClickHandler(new AktiverHandler());
			}
			

			

		}

		vPanel.add(t);


	}

	private class DeaktiverHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			
			
			// if previous cancel open - force cancel operation�
			if (previousCancel != null)
				previousCancel.fireEvent(new ClickEvent(){});


			// get rowindex where event happened
			final int eventRowIndex = t.getCellForEvent(event).getRowIndex();
			
			// get delete anchor ref for cancel operation
			final Anchor deaktiver =  (Anchor) event.getSource();

			
			final Anchor aktiver = new Anchor("aktiver");
			aktiver.addClickHandler(new AktiverHandler());
			
			Anchor ok = new Anchor("ok");
			ok.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {

					// here you will normally fetch the primary key of the row 
					// and use it for location the object to be deleted
					if(eventRowIndex == oprDTO.getOprID()) {
						Window.alert("Du kan ikke deaktivere administratoren");
						t.setWidget(eventRowIndex, 3, deaktiver);
						t.clearCell(eventRowIndex, 4);
					}else {
						oprDAO.deactivatePerson(eventRowIndex);
						t.setText(eventRowIndex, 2, "Ikke aktiv");
						t.setWidget(eventRowIndex, 3, aktiver);
						t.clearCell(eventRowIndex, 4);
					}
				}

			});

			Anchor fortryd = new Anchor("fortryd");
			previousCancel = fortryd;
			fortryd.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					t.setWidget(eventRowIndex, 3, deaktiver);
					t.clearCell(eventRowIndex, 4);
				}

			});

			// showing ok and cancel widgets
			t.setWidget(eventRowIndex, 3 , ok);
			t.setWidget(eventRowIndex, 4 , fortryd);
		}


	}
	
	private class AktiverHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			Window.alert("Test");
			
		}
		
	}

}

