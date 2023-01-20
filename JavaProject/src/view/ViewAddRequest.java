package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ActionDeclineAddRequest;
import controller.ActionRemoveReview;
import controller.ActionValidateAddRequest;
import model.AddRequest;
import model.Review;

public class ViewAddRequest extends JPanel{
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(225,225,225);
	
	//Parent
	AddRequestsList parent;
	
	//Model
	AddRequest add_request;
	
	// Composants du JPanel
	JLabel add_request_author;
	JLabel game_to_add;
	JLabel date_add_request;
	JLabel status_add_request;
	
	JButton validate_request;
	JButton decline_request;
		
	public ViewAddRequest(AddRequestsList p_parent, AddRequest p_add_request) {
		setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.setLayout(new FlowLayout());
        
        this.parent = p_parent;
        this.add_request = p_add_request;	
        
		initComponents();
	}
	
	private void initComponents () {
		
		//Céation des composants
		add_request_author = new JLabel("Auteur : " + add_request.getUser().getPseudo() );
		game_to_add = new JLabel("Jeu à ajouter : " + add_request.getGameToAdd() );
		date_add_request = new JLabel("Date: " + add_request.getDate() );
		status_add_request = new JLabel("Status : " + add_request.getStatus() );
		
		this.add(add_request_author, FlowLayout.LEFT);
        this.add(game_to_add, FlowLayout.LEFT);
        this.add(date_add_request, FlowLayout.LEFT);
        this.add(status_add_request, FlowLayout.LEFT);
        
        //Boutons Action
		if (add_request.getStatus().equalsIgnoreCase("en attente")) {
			ActionValidateAddRequest l_action_validate = new ActionValidateAddRequest(this.parent, this.add_request);
			validate_request = new JButton(l_action_validate);
			validate_request.setText(ActionValidateAddRequest.NOM_ACTION);
			validate_request.setBackground(Color.green);
			
			ActionDeclineAddRequest l_action_decline = new ActionDeclineAddRequest(this.parent, this.add_request);
			decline_request = new JButton(l_action_decline);
			decline_request.setText(ActionDeclineAddRequest.NOM_ACTION);
			decline_request.setBackground(Color.red);
			
			this.add(validate_request, FlowLayout.LEFT);
	        this.add(decline_request, FlowLayout.LEFT);
			
			
		}
	}
}

