package view;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import controller.ActionLogin;
import model.Model;
import model.User;


public class LoginInterface extends JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 1000;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(200,200,200);
	
	public CardLayout card_layout;
	
	// Model
	private Model model; 
	
	// Composants du JPanel
	private JLabel label_username;
	private JLabel label_password;
	private JTextField text_username;
	private JPasswordField field_password;
	private JButton button_login;
	
	public LoginInterface ( int p_width, int p_height, Color p_background, CardLayout p_card_layout, Model p_model){
		setBackground(p_background);
		setPreferredSize(new Dimension(p_width,p_height));
		
		this.model = p_model;
		this.card_layout = p_card_layout;
		
		initComponents();
	}
	
	private void initComponents () {
		
		// Création des composants
	    label_username = new JLabel("Nom d'utilisateur :");
	    text_username = new JTextField(20);
	    label_password = new JLabel("Mot de passe :");
	    field_password = new JPasswordField(20);
		
		//Bouton Login
		ActionLogin l_login_action = new ActionLogin(this);
		button_login = new JButton(l_login_action) ;
		button_login.setText(ActionLogin.NOM_ACTION);
		
		//ajouter une image
		//ImageIcon icon = new ImageIcon("image_Jeux/test.png");
		//this.add(new JLabel(icon));
		
		//Ajout des composants au panel
		this.add(label_username);
		this.add(text_username);
		this.add(label_password);
		this.add(field_password);
		this.add(button_login);
	}
	
	public JTextField getUsername (){
		return this.text_username;
	}
	
	public JPasswordField getPassword() {
		return this.field_password;
	}
	
	public Vector<User> getListAdmin() {
		Vector<User> admins = new Vector<User>();
		Vector<User> users = model.getUsers();
		
		for(User i : users) {
			if (i.getType().equalsIgnoreCase("administrateur")) {
				admins.add(i);
			}
		}
		
		return admins;
	}
}