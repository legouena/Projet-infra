package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ActionRemoveGame;
import controller.ActionRemoveUser;
import model.Game;
import model.Review;
import model.User;

public class GameProfil extends JPanel{
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(200,200,200);
	
	//Parent
	JDialog parent;
	
	//Model
	Game game_selected;
	GamesList games_list;
	Vector<Review> reviews;
	
	// Composants du JPanel
	JLabel name_game;
	JLabel category_game;
	JLabel creation_date;
	JLabel release_date;
	JLabel average_grade;
	JLabel studio_game;
	Vector<JPanel> view_reviews;
		
	public GameProfil(JDialog p_parent, GamesList p_games_list, Game p_game_selected) {
		setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.setLayout(new FlowLayout());
        
        this.parent = p_parent;
        this.game_selected = p_game_selected;
        this.games_list = p_games_list;
        this.reviews = new Vector<Review>();
        this.view_reviews = new Vector<JPanel>();
        
		initComponents();
	}
	
	private void initComponents () {
		
		//Céation des composants
		name_game = new JLabel("Name : " + game_selected.getName() );
		category_game = new JLabel("Catégorie : " + game_selected.getCategory());
        studio_game = new JLabel("Studio : " + game_selected.getStudio());
        release_date = new JLabel("Date de sortie : " + game_selected.getReleaseDate());
        creation_date = new JLabel("Date de création : " + game_selected.getCreationDate());
        average_grade = new JLabel("Note moyenne : " + Float.toString(game_selected.getAverageGrade()));
        
        //Bouton supprimer jeu
  		ActionRemoveGame l_remove_action = new ActionRemoveGame(this, this.games_list, this.game_selected);
  		JButton button_remove = new JButton(l_remove_action) ;
  		button_remove.setText(ActionRemoveGame.NOM_ACTION);
  		
  		this.add(name_game, FlowLayout.LEFT);
        this.add(category_game, FlowLayout.LEFT);
        this.add(studio_game, FlowLayout.LEFT);
        this.add(release_date, FlowLayout.LEFT);
        this.add(creation_date, FlowLayout.LEFT);
        this.add(average_grade, FlowLayout.LEFT);
        this.add(button_remove);
        
        this.reviews = this.games_list.getModel().getReviewForAGame(this.game_selected);
        for(Review i : this.reviews) {
            
		  ViewReview l_view_review = new ViewReview(this, i) ;
		  this.view_reviews.add(l_view_review);
		  this.add(l_view_review);
        }
	}
	
	public void update() {
		for(JPanel i:this.view_reviews) {
			this.remove(i);
		}
		
		this.view_reviews.clear();
		
        this.reviews = this.games_list.getModel().getReviewForAGame(this.game_selected);
		
        for(Review i : this.reviews) {
            
  		  ViewReview l_view_review = new ViewReview(this, i) ;
  		  this.view_reviews.add(l_view_review);
  		  this.add(l_view_review);
        }
        this.repaint();
	}
	
	public GamesList getGamesList() {
		return this.games_list;
	}
	
	public void remove() {
		this.parent.setVisible(false);
	}
}
