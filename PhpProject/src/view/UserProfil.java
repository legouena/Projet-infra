package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.ActionRemoveUser;
import controller.ActionSelectUser;
import model.Game;
import model.Model;
import model.Review;
import model.User;

public class UserProfil extends JPanel{
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(200,200,200);
	
	//Parent
	JDialog parent;
	
	//Model
	User user_selected;
	UsersList users_list;
	Vector<Review> reviews;
	
	// Composants du JPanel
	JLabel pseudo_user;
	JLabel email_user;
	JLabel creation_date;
	JLabel notoriety_user;
	Vector<JPanel> view_reviews;
		
	public UserProfil(JDialog p_parent, UsersList p_users_list, User p_user_selected) {
		setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.setLayout(new FlowLayout());
        
        this.parent = p_parent;
        this.user_selected = p_user_selected;
        this.users_list = p_users_list;
        this.reviews = new Vector<Review>();
        this.view_reviews = new Vector<JPanel>();
        
		initComponents();
	}
	
	private void initComponents () {
		
		//Céation des composants
        pseudo_user = new JLabel("Pseudo : " + user_selected.getPseudo() );
        email_user = new JLabel("Email : " + user_selected.getMail());
        creation_date = new JLabel("Création date : " + user_selected.getCreationDate());
        notoriety_user = new JLabel("Notoriety : " + Float.toString(user_selected.getNotoriety()));
        
        //Bouton supprimer utilisateur
  		ActionRemoveUser l_remove_action = new ActionRemoveUser(this, this.users_list, this.user_selected);
  		JButton button_remove = new JButton(l_remove_action) ;
  		button_remove.setText(ActionRemoveUser.NOM_ACTION);
  		
  		this.add(pseudo_user, FlowLayout.LEFT);
        this.add(email_user, FlowLayout.LEFT);
        this.add(creation_date, FlowLayout.LEFT);
        this.add(notoriety_user, FlowLayout.LEFT);
        this.add(button_remove);
        
        this.reviews = this.users_list.getModel().getReviewForAUser(user_selected);
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
		
		/* Users List */
        this.reviews = this.users_list.getModel().getReviewForAUser(this.user_selected);
		
        for(Review i : this.reviews) {
            
  		  ViewReview l_view_review = new ViewReview(this, i) ;
  		  this.view_reviews.add(l_view_review);
  		  this.add(l_view_review);
        }
        this.repaint();
	}
	
	public UsersList getUsersList() {
		return this.users_list;
	}
	
	public void remove() {
		this.parent.setVisible(false);
	}
}
