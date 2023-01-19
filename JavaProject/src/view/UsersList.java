package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ActionLogin;
import controller.ActionSelectUser;
import database.Database;
import model.Model;
import model.Review;
import model.User;

public class UsersList extends JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 1000;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(100,100,100);
	
	//Model/database
	Model model;
	Database database;
	
	Vector<JButton> users_button;
	
	public UsersList(Model p_model, Database p_database) {
		this(LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT,COULEUR_FOND_PAR_DEFAUT, p_model, p_database);
	}
	
	public UsersList(int p_width, int p_height, Color p_background, Model p_model, Database p_database) {
		setBackground(p_background);
		setSize(new Dimension(p_width,p_height));
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        this.database = p_database;
        this.model = p_model;
        this.users_button = new Vector<JButton>();
        
		initComponents();
	}
	
	private void initComponents () {
		
		/* Users List */
        Vector<User> l_users = model.getUsers();
        
        ActionSelectUser l_action_select_user = new ActionSelectUser(this);
        for(User i : l_users) {
        
    		JButton l_user = new JButton(l_action_select_user) ;
    		l_user.setText(i.getPseudo()+" ("+i.getType()+")");
    		this.users_button.add(l_user);
    		this.add(l_user);
        }
	}
	
	public void removeUser(User p_user) {
		/* When bdd is here */
//		try {
//			
//			database.removeUser(p_user);
//			
//		}catch (SQLException | ClassNotFoundException a) {
//    
//    	System.out.println(a.getMessage());
//    }
		model.removeUser(p_user);
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
	
	public void update() {
		
		for(JButton i:this.users_button) {
			this.remove(i);
		}
		
		this.users_button.clear();
		
		/* Users List */
        Vector<User> l_users = model.getUsers();
		
		ActionSelectUser l_action_select_user = new ActionSelectUser(this);
        for(User i : l_users) {
        
    		JButton l_user = new JButton(l_action_select_user) ;
    		l_user.setText(i.getPseudo()+" ("+i.getType()+")");
    		this.users_button.add(l_user);
    		this.add(l_user);
        }
        this.repaint();
	}
	
	public Model getModel() {
		return model;
	}

}
