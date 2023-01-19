package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Game;
import model.User;
import view.GameProfil;
import view.GamesList;
import view.UserProfil;
import view.UsersList;

public class ActionRemoveGame extends AbstractAction{
	
	public static final String NOM_ACTION = "Supprimer le jeu";
	
	// For Display
	private GameProfil profil_game_interface;
	// For Model
	private GamesList games_list;
	private Game game_selected;
	
	public ActionRemoveGame (GameProfil p_profil_game_interface, GamesList p_games_list, Game p_game_selected) {
		super(NOM_ACTION);
		
		this.game_selected = p_game_selected;
		this.games_list = p_games_list;
		this.profil_game_interface = p_profil_game_interface;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		
		//Debug
		//System.out.println("remove");
		
		int result = JOptionPane.showConfirmDialog(profil_game_interface, "Voulez-vous supprimer le jeu ?","confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            games_list.removeGame(game_selected);
            games_list.update();
            this.profil_game_interface.remove();
        }
        else {
        }
		
	}
}