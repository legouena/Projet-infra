package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import database.Database;
import model.Model;
import view.LoginInterface;
import view.Dashboard;


public class AlloGame {
	
	public CardLayout card_layout;
	
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new AlloGame();
			}
			});
	}
	
	private AlloGame () {
		this("AlloGame");
	}
	private AlloGame (String p_title) {
		
		JFrame l_frame = new JFrame(p_title);
		l_frame.setSize(new Dimension(800,600));
		l_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		l_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
		card_layout = new CardLayout();
		l_frame.setLayout(card_layout);
		
		// Création du model
		Model l_model = new Model();
		
		// Initialisation base de données
		Database l_database = new Database(l_model);
		
		// Pour après la création de la bdd
//		try {
//			l_database.getUsers();
//			l_database.getGames();
//		}catch (SQLException | ClassNotFoundException a) {
//	    
//	    	System.out.println(a.getMessage());
//	    }
		
		
		LoginInterface l_page_login = new LoginInterface(l_frame.getWidth(),l_frame.getHeight(),new Color(200,200,200), card_layout, l_model);
		l_frame.add(l_page_login, "Page Login");
		
		Dashboard dashboard = new Dashboard(l_frame.getWidth(),l_frame.getHeight(),new Color(200,200,200), card_layout, l_model, l_database);
		l_frame.add(dashboard, "Page Dashboard");
		
		
		card_layout.show(l_frame.getContentPane(), "Page Login");
		
		l_frame.pack();
		l_frame.setLocationRelativeTo(null);
		l_frame.setVisible(true);
	}
}
