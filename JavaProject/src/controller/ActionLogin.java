package controller;

// swing elements 
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.User;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Vector;

import view.LoginInterface;

public class ActionLogin extends AbstractAction{
	
	public static final String NOM_ACTION = "Login";
	
	private LoginInterface login_interface;
	
	public ActionLogin (LoginInterface p_login_interface  ) {
		super(NOM_ACTION);
		
		//Lien loginInterface
		this.login_interface = p_login_interface;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		
		// Récupération liste administrateur
		Vector<User> admins = login_interface.getListAdmin();
		
		// Récupération des données saisies
	    String l_username = login_interface.getUsername().getText();
	    char[] l_password = login_interface.getPassword().getPassword();

	    boolean admin_access = false;
	    
	    for (User i : admins) {
	    	if(l_username.equals(i.getPseudo()) && Arrays.equals(l_password, i.getPassword().toCharArray())) {
	    		admin_access = true;
	    	}
	    }
	    
	    if ( admin_access) {
	    	//Debug
	    	//System.out.println("Connexion réussie !");
	    	
	    	JFrame l_frame = (JFrame)login_interface.getTopLevelAncestor();  
		    login_interface.card_layout.show(l_frame.getContentPane(), "Page Dashboard");
	    }else {
	    	//Debug
	    	//System.out.println("Connexion échouée !");
	    	
	    	Container l_container= login_interface.getTopLevelAncestor();
			JFrame l_frame = null;
			if(l_container instanceof JFrame) {
				l_frame = (JFrame) l_container;
			}else {
				System.out.println("problem JFrame container");
			}
	    	JOptionPane.showMessageDialog(l_frame, "Email ou mot de passe incorrect");
	    }
		
	}
}