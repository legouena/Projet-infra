package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.AddRequest;
import model.Review;
import view.AddRequestsList;
import view.GameProfil;
import view.UserProfil;
import view.ViewAddRequest;

public class ActionValidateAddRequest extends AbstractAction{
	
	public static final String NOM_ACTION = "Valider";
	
	// For Display
	private AddRequestsList container;
	// For Model
	private AddRequest add_request;
	
	public ActionValidateAddRequest (AddRequestsList p_container, AddRequest p_add_request) {
		super(NOM_ACTION);
		
		this.container = p_container;
		this.add_request = p_add_request;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		
		//Debug
		//System.out.println("remove");
		
		int result = JOptionPane.showConfirmDialog(this.container, "Voulez-vous valider la requête","confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
           this.container.validateAddRequest(this.add_request);
           this.container.update();
        }
        else {
        }
		
	}
}
