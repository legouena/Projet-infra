package controller;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;

import view.AddGamePopup;
import view.Dashboard;
import view.GameProfil;
import view.GamesList;

public class ActionAddGame extends AbstractAction{
	
	public static final String NOM_ACTION = "Ajouter Jeu";
	
	private GamesList games_list;
	
	public ActionAddGame (GamesList p_games_list  ) {
		super(NOM_ACTION);
		
		//Lien dashboard
		this.games_list = p_games_list;
		
	}
	
	public void actionPerformed (ActionEvent p_event ) {
		
		Container l_container= games_list.getTopLevelAncestor();
		JFrame l_frame = null;
		if(l_container instanceof JFrame) {
			l_frame = (JFrame) l_container;
		}else {
			System.out.println("problem JFrame container");
		}
		
		JDialog l_popup = new JDialog(l_frame);
		l_popup.setLayout(new BorderLayout());
		l_popup.setSize(new Dimension(1200, 800));
		
		AddGamePopup l_add_game_popup = new AddGamePopup(l_popup,this.games_list);
		l_popup.add(l_add_game_popup, BorderLayout.CENTER);
		l_popup.setVisible(true);
		
		
	}
}
