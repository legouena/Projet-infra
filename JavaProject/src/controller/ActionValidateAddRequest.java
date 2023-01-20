package controller;

import java.awt.event.ActionEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
        
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");
        
        
        String codeM = "function sendEmailData(){"
        		+ "	Email.send({"
        		+ "		Host: \"smtp.gmail.com\","
        		+ "		Username: 'allogame.eseo@gmail.com',"
        		+ "		Password: 'mgqffggdbgkasqjw',"
        		+ "		To: '"+this.add_request.getUser().getMail()+"',"
        		+ "		From: 'allogame.eseo@gmail.com',"
        		+ "		Subject: 'Game Add Request',"
        		+ "		Body: 'Your add request has been accepted!'"
        		+ "	})	}sendEmailData();";
        
        try {
     	  System.out.println(engine.eval(codeM)); 
        } catch (ScriptException e) {
     	   System.out.println(e.getMessage());
        }
		
	}
}
