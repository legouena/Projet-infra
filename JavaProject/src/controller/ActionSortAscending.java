package controller;

// swing elements 
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.User;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Vector;

import view.GamesList;
import view.LoginInterface;
import view.UsersList;

public class ActionSortAscending extends AbstractAction{
	
	public static final String NOM_ACTION = "Sort ASC";
	
	private JPanel parent;
	
	public ActionSortAscending (JPanel p_parent  ) {
		super(NOM_ACTION);
		
		//Lien loginInterface
		this.parent = p_parent;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		if(this.parent instanceof UsersList) {
			UsersList l_users_list = (UsersList)this.parent;
			l_users_list.sortAscOrder();
		}else if(this.parent instanceof GamesList) {
			GamesList l_games_list = (GamesList)this.parent;
			l_games_list.sortAscOrder();
		}
		
	}
}