package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Model;
import model.Review;
import view.GameProfil;
import view.UserProfil;

public class ActionRemoveReview extends AbstractAction{
	
	public static final String NOM_ACTION = "Supprimer la critique";
	
	// For Display
	private JPanel container;
	// For Model
	private Review review_selected;
	
	public ActionRemoveReview (JPanel p_container, Review p_review_selected) {
		super(NOM_ACTION);
		
		this.container = p_container;
		this.review_selected = p_review_selected;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		
		//Debug
		//System.out.println("remove");
		
		int result = JOptionPane.showConfirmDialog(this.container, "Voulez-vous supprimer la review ?","confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if(this.container instanceof UserProfil) {
            	UserProfil l_user_profil = (UserProfil)this.container;
                l_user_profil.getUsersList().removeReview(review_selected);
                l_user_profil.update();
            }else {
            	GameProfil l_game_profil = (GameProfil)this.container;
            	l_game_profil.getGamesList().removeReview(review_selected);
                l_game_profil.update();
            }
        }
        else {
        }
		
	}
}
