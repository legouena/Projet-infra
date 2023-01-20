package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ActionAddGameConfirmation;
import controller.ActionLogin;
import controller.ActionRemoveUser;
import model.User;

public class AddGamePopup extends JPanel{
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(200,200,200);
	
	//Parent
	JDialog parent;
	
	//Model
	GamesList games_list;
	
	// Composants du JPanel
	JLabel name_game;
	JLabel category_game;
	JLabel creation_date;
	JLabel release_date;
	JLabel average_grade;
	JLabel studio_game;
	
	private JTextField text_name_game;
	private JTextField text_category_game;
	private JTextField text_creation_date;
	private JTextField text_release_date;
	private JTextField text_average_grade;
	private JTextField text_studio_game;
	
	private JButton add_button;
		
	public AddGamePopup(JDialog p_parent, GamesList p_games_list) {
		setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.setLayout(new FlowLayout());
        
        this.parent = p_parent;
        this.games_list = p_games_list;
        
		initComponents();
	}
	
	private void initComponents () {
		
		//Céation des composants
		name_game = new JLabel("Name : ");
		category_game = new JLabel("Catégorie : ");
        studio_game = new JLabel("Studio : ");
        release_date = new JLabel("Date de sortie : ");
        
        text_name_game = new JTextField(20);
        text_category_game = new JTextField(20);
        text_studio_game = new JTextField(20);
        text_release_date = new JTextField(20);
        
        //Button Add
        ActionAddGameConfirmation l_add_game_action = new ActionAddGameConfirmation(this.games_list,this);
        add_button = new JButton(l_add_game_action) ;
        add_button.setText(ActionAddGameConfirmation.NOM_ACTION);
        
        
        this.add(name_game);
        this.add(text_name_game);
        this.add(category_game);
        this.add(text_category_game);
        this.add(studio_game);
        this.add(text_studio_game);
        this.add(release_date);
        this.add(text_release_date);
        
        this.add(add_button);
        
        
	}
	
	public JTextField getNameGame() {
		return this.text_name_game;
	}
	
	public JTextField getCategoryGame() {
		return this.text_category_game;
	}
	
	public JTextField getStudioGame() {
		return this.text_studio_game;
	}
	
	public JTextField getReleaseDate() {
		return this.text_release_date;
	}
	
	public void remove() {
		this.parent.setVisible(false);
	}
}
