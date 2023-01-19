package controller;

//swing elements
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Game;
import model.User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import view.GameProfil;
import view.GamesList;
import view.UserProfil;
import view.UsersList;

public class ActionSelectGame extends AbstractAction{
	
	private GamesList games_list;

	public ActionSelectGame (GamesList p_games_list  ) {
		super();
		
		//Lien dashboard
		this.games_list = p_games_list;
		
	}
	
	public GamesList getGames_list() {
		return this.games_list;
	}
	
	public void actionPerformed (ActionEvent p_event ) {

		//Debug
		//System.out.println(l_button_clicked.getText());
		
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
		
		//Récupération de l'utilisateur sélectionné
		JButton l_button_clicked = (JButton)p_event.getSource();
		String l_button_text = l_button_clicked.getText();
		String l_name_game = l_button_text.substring(0, l_button_text.indexOf(" "));
		
		Game l_game_selected = null;
		Vector<Game> l_games = games_list.getModel().getGames();
		for (Game i : l_games) {
			if(i.getName().equalsIgnoreCase(l_name_game)) {
				l_game_selected = i;
			}
		}
		
		if(l_game_selected == null) {
			System.out.println("problem game not found");
		}
		
		GameProfil l_game_profil = new GameProfil(l_popup,this.games_list, l_game_selected);
		l_popup.add(l_game_profil, BorderLayout.CENTER);
		l_popup.setVisible(true);
	}
}
