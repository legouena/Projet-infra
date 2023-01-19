package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ActionRemoveReview;
import controller.ActionRemoveUser;
import model.Model;
import model.Review;
import model.User;

public class ViewReview extends JPanel{
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(255,255,255);
	
	//Parent
	JPanel parent;
	
	//Model
	Review review;
	
	// Composants du JPanel
	JLabel review_author;
	JLabel text_review;
	JLabel grade_review;
	JLabel game_review;
	JLabel date_review;
	JLabel reputation_review;
		
	public ViewReview(JPanel p_parent, Review p_review) {
		setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.setLayout(new FlowLayout());
        
        this.parent = p_parent;
        this.review = p_review;
        
		initComponents();
	}
	
	private void initComponents () {
		
		//Céation des composants
		review_author = new JLabel("Auteur : " + review.getUser().getPseudo() );
		text_review = new JLabel("Critique : " + review.getText() );
		grade_review = new JLabel("Note: " + review.getGrade() );
		game_review = new JLabel("Jeu : " + review.getGame().getName() );
		date_review = new JLabel("Date : " + review.getDate() );
		reputation_review = new JLabel("Reputation : " + review.getReputation() );
        
        //Bouton supprimer review
		ActionRemoveReview l_remove_action = new ActionRemoveReview(this.parent, this.review);
  		JButton button_remove = new JButton(l_remove_action) ;
  		button_remove.setText(ActionRemoveReview.NOM_ACTION);
  		
  		this.add(review_author, FlowLayout.LEFT);
        this.add(text_review, FlowLayout.LEFT);
        this.add(grade_review, FlowLayout.LEFT);
        this.add(game_review, FlowLayout.LEFT);
        this.add(date_review, FlowLayout.LEFT);
        this.add(reputation_review, FlowLayout.LEFT);
        this.add(button_remove);
	}
}

