package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.ActionLogout;
import database.Database;
import model.Model;

public class Dashboard extends JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 1000;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(100,100,100);
	
	public CardLayout card_layout;
	
	//Model/Database
	Database database;
	Model model;
	
	// Composants du JPanel
	private JTabbedPane tabbed_pane;
	private UsersList users_list;
	private GamesList games_list;
	private AddRequestsList add_requests;
	private JButton buttonLogout;
		
	public Dashboard(int p_width, int p_height, Color p_background, CardLayout p_card_layout, Model p_model, Database p_database) {
		setBackground(p_background);
		setSize(new Dimension(p_width,p_height));
        this.setLayout(new BorderLayout());
		
        this.database = p_database;
        this.model = p_model;
        this.card_layout = p_card_layout;
        
		initComponents();
	}
	
	private void initComponents () {
		
        /* Users List */ 
        users_list = new UsersList(model, database);
        
        /* Games List */
	    games_list = new GamesList(model, database);
	    
	    /* Add Requests */ 
	    add_requests = new AddRequestsList(model, database);
        
	    /* Top Bar */
        tabbed_pane = new JTabbedPane();
        tabbed_pane.addTab("Utilisateurs", users_list);
        tabbed_pane.addTab("Jeux", games_list);
        tabbed_pane.addTab("Add Requests", add_requests);
        
        
        //--------------------------------------------------------------------------------
        
        
        /* Right Bar */
        JPanel l_button_panel = new JPanel();
        l_button_panel.setLayout(new BoxLayout(l_button_panel, BoxLayout.X_AXIS));
        
        //Bouton Logout
  		ActionLogout l_login = new ActionLogout(this);
  		buttonLogout = new JButton(l_login) ;
  		buttonLogout.setText(ActionLogout.NOM_ACTION);
        
  		l_button_panel.add(buttonLogout);

        
        this.add(tabbed_pane, BorderLayout.CENTER);
        this.add(l_button_panel, BorderLayout.EAST);
	}
  }
                              
