package controller;

//swing elements 
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.User;
import view.UserProfil;
import view.UsersList;

import java.awt.event.ActionEvent;

public class ActionRemoveUser extends AbstractAction{
	
	public static final String NOM_ACTION = "Supprimer utilisateur";
	
	// For Display
	private UserProfil profil_user_interface;
	// For Model
	private UsersList users_list;
	private User user_selected;
	
	public ActionRemoveUser (UserProfil p_profil_user_interface, UsersList p_users_list, User p_user_selected) {
		super(NOM_ACTION);
		
		this.user_selected = p_user_selected;
		this.users_list = p_users_list;
		this.profil_user_interface = p_profil_user_interface;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		
		//Debug
		System.out.println("remove");
		
		int result = JOptionPane.showConfirmDialog(profil_user_interface, "Voulez-vous supprimer l'utilisateur ?","confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            users_list.removeUser(user_selected);
            users_list.update();
            this.profil_user_interface.remove();
        }
        else {
        }
		
	}
}
