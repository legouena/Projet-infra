package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import model.AddRequest;
import model.Model;
import model.Review;
import model.User;

public class AddRequestsList extends JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 1000;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(100,100,100);
	
	//Model/database
	Model model;
	Database database;
	Vector<AddRequest> add_requests;
	
	//Composants du JPanel
	Vector<JPanel> view_add_requests;
	
	public AddRequestsList(Model p_model, Database p_database) {
		this(LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT,COULEUR_FOND_PAR_DEFAUT, p_model, p_database);
	}
	
	public AddRequestsList(int p_width, int p_height, Color p_background, Model p_model, Database p_database) {
		setBackground(p_background);
		setSize(new Dimension(p_width,p_height));
        this.setLayout(new FlowLayout());
        
        this.database = p_database;
        this.model = p_model;
        this.add_requests = new Vector<AddRequest>();
        this.view_add_requests = new Vector<JPanel>();
        
		initComponents();
	}
	
	private void initComponents () {

		this.add_requests = this.model.getAddRequests();
		for(AddRequest i : this.add_requests) {
            
		  ViewAddRequest l_view_add_request = new ViewAddRequest(this, i) ;
		  this.view_add_requests.add(l_view_add_request);
		  this.add(l_view_add_request);
        }
	}
	
	public void validateAddRequest(AddRequest p_add_request) {
		
		/* When bdd is here */
//		try {
//			
//			database.validateAddRequest(p_add_request);
//			
//		}catch (SQLException | ClassNotFoundException a) {
//    
//    	System.out.println(a.getMessage());
		
		this.model.validateAddRequest(p_add_request);
	}
	
	public void declineAddRequest(AddRequest p_add_request) {
		
		/* When bdd is here */
//		try {
//			
//			database.declineAddRequest(p_add_request);
//			
//		}catch (SQLException | ClassNotFoundException a) {
//    
//    	System.out.println(a.getMessage());
		
		this.model.declineAddRequest(p_add_request);
	}
	
	public void update() {
		for(JPanel i:this.view_add_requests) {
			this.remove(i);
		}
		
		this.view_add_requests.clear();
		
		/* Users List */
        this.add_requests = this.model.getAddRequests();
		
        for(AddRequest i : this.add_requests) {
            
  		  ViewAddRequest l_view_add_request = new ViewAddRequest(this, i) ;
  		  this.view_add_requests.add(l_view_add_request);
  		  this.add(l_view_add_request);
        }
        this.repaint();
	}
	
	public Model getModel() {
		return model;
	}

}
