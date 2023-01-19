package controller;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Game;
import view.AddGamePopup;
import view.GamesList;

public class ActionAddGameConfirmation extends AbstractAction{
	
	public static final String NOM_ACTION = "Ajouter Jeu";
	
	private GamesList games_list;
	private AddGamePopup add_game_popup;
	
	//Game Info
	String name_game;
	String category_name;
	String studio_game;
	String release_date;
	String creation_date;
	float average_grade;
	int game_index;
	
	public ActionAddGameConfirmation (GamesList p_games_list, AddGamePopup p_add_game_popup) {
		super(NOM_ACTION);
		
		//Lien dashboard
		this.add_game_popup = p_add_game_popup;
		this.games_list = (p_games_list);
		
		
		this.games_list = p_games_list;
		this.name_game = new String();
		this.category_name = new String();
		this.studio_game = new String();
		this.release_date = new String();
		this.creation_date = new String();
		this.average_grade = (float)0;
		this.game_index = 0;
		
		
	}
	
	public void actionPerformed (ActionEvent p_event ) {
		
		name_game = this.add_game_popup.getNameGame().getText();
		category_name = this.add_game_popup.getCategoryGame().getText();
		studio_game = this.add_game_popup.getStudioGame().getText();
		release_date = this.add_game_popup.getReleaseDate().getText();
		average_grade = (float)0;
		
		SimpleDateFormat l_s = new SimpleDateFormat("dd/MM/yyyy");
	    Date l_date = new Date();
		String creation_date = l_s.format(l_date);
		
		game_index = this.games_list.getModel().getLastIndexGame()+1;
		
		Game l_game_to_be_added = new Game (game_index, name_game, creation_date,
											release_date, category_name, studio_game, average_grade);
		
		
		int result = JOptionPane.showConfirmDialog(add_game_popup, "Voulez-vous ajouter le jeu ?","confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            this.games_list.addGame(l_game_to_be_added);
            this.games_list.update();
            this.add_game_popup.remove();
        }
        else {
        }
		
	}
}
