package view;

import database.Database;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ActionAddGame;
import controller.ActionLogin;
import controller.ActionSelectGame;
import controller.ActionSelectUser;
import model.Game;
import model.Model;
import model.Review;
import model.User;

public class GamesList extends JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 1000;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(100,100,100);
	
	private Model model;
	private Database database;
	
	private Vector<JButton> games_button;
	private JButton add_button;
	
	public GamesList(Model p_model, Database p_database) {
		this(LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT,COULEUR_FOND_PAR_DEFAUT, p_model, p_database);
	}
	
	public GamesList(int p_width, int p_height, Color p_background, Model p_model, Database p_database) {
		setBackground(p_background);
		setSize(new Dimension(p_width,p_height));
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        this.database = p_database;
        this.model = p_model;
        this.games_button = new Vector<JButton>();
        
		initComponents();
	}
	
	private void initComponents () {
		
		
		//Bouton Login
		ActionAddGame l_add_game_action = new ActionAddGame(this);
		add_button = new JButton(l_add_game_action) ;
		add_button.setText(ActionAddGame.NOM_ACTION);
		add_button.setBackground(Color.green);
		this.add(add_button);
		
		/* Games List */
        Vector<Game> l_games = model.getGames();
        
        ActionSelectGame l_action_select_game = new ActionSelectGame(this);
        for(Game i : l_games) {
      
  		  JButton l_game = new JButton(l_action_select_game) ;
  		  l_game.setText(i.getName()+" ("+i.getCategory()+")");
  		  this.games_button.add(l_game);
  		  this.add(l_game);
        }
        
        
        
        
	}
      	
  	public void removeGame(Game p_game) {
  	
  		/* When bdd is here */
//  		try {
//  			
//  			database.removeGame(p_game);
//  			
//  		}catch (SQLException | ClassNotFoundException a) {
//	    
//	    	System.out.println(a.getMessage());
//	    }
  		
  		model.removeGame(p_game);
  	}
  	
  	public void removeReview(Review p_review) {
		/* When bdd is here */
//		try {
//			
//			database.removeReview(p_review);
//			
//		}catch (SQLException | ClassNotFoundException a) {
//    
//    	System.out.println(a.getMessage());
//    }
		model.removeReview(p_review);
	}
  	
  	public void addGame(Game p_game) {
  		
  		/* When bdd is here */
//		try {
//		
//		database.addGame(p_game);
//		
//		}catch (SQLException | ClassNotFoundException a) {
//
//			System.out.println(a.getMessage());
//		}
  		
  		model.addGame(p_game);
  	}
  	
  	public void update() {
  		
  		for(JButton i:this.games_button) {
  			this.remove(i);
  		}
  		
  		this.games_button.clear();
  		
  		/* Users List */
        Vector<Game> l_games = model.getGames();
  		
        ActionSelectGame l_action_select_game = new ActionSelectGame(this);
        for(Game i : l_games) {
      
  		  JButton l_game = new JButton(l_action_select_game) ;
  		  l_game.setText(i.getName()+" ("+i.getCategory()+")");
  		  this.games_button.add(l_game);
  		  this.add(l_game);
        }
        this.repaint();
  	 }
  	
  	public Model getModel() {
  		return model;
  	}

  }