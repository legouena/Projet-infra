package controller;


//swing elements
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import view.UserProfil;
import view.UsersList;

public class ActionSelectUser extends AbstractAction{
	
	private UsersList users_list;

	public ActionSelectUser (UsersList p_users_list  ) {
		super();
		
		//Lien dashboard
		this.users_list = p_users_list;
		
	}
	
	public UsersList getUsers_list() {
		return users_list;
	}
	
	public void actionPerformed (ActionEvent p_event ) {

		//Debug
		//System.out.println(l_button_clicked.getText());
		
		Container l_container= users_list.getTopLevelAncestor();
		JFrame l_frame = null;
		if(l_container instanceof JFrame) {
			l_frame = (JFrame) l_container;
		}else {
			System.out.println("problem JFrame container");
		}
		
		JDialog l_popup = new JDialog(l_frame);
		l_popup.setLayout(new BorderLayout());
		l_popup.setSize(new Dimension(1200, 800));
		
		//Récupération de l'utilisateur sélectionné
		JButton l_button_clicked = (JButton)p_event.getSource();
		String l_button_text = l_button_clicked.getText();
		String l_pseudo = l_button_text.substring(0, l_button_text.indexOf(" "));
		
		User l_user_selected = null;
		Vector<User> users = users_list.getModel().getUsers();
		for (User i : users) {
			if(i.getPseudo().equalsIgnoreCase(l_pseudo)) {
				l_user_selected = i;
			}
		}
		
		if(l_user_selected == null) {
			System.out.println("problem user not found");
		}
		
		UserProfil l_user_profil = new UserProfil(l_popup,this.users_list, l_user_selected);
		l_popup.add(l_user_profil, BorderLayout.CENTER);
		l_popup.setVisible(true);
	}
}
