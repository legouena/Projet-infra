package controller;

// swing elements
import javax.swing.AbstractAction;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;

import view.Dashboard;

public class ActionLogout extends AbstractAction{
	
	public static final String NOM_ACTION = "Logout";
	
	private Dashboard dashboard;
	
	public ActionLogout (Dashboard p_dashboard  ) {
		super(NOM_ACTION);
		
		//Lien dashboard
		this.dashboard = p_dashboard;
		
	}
	public void actionPerformed (ActionEvent p_event ) {
		
	    JFrame l_frame = (JFrame)dashboard.getTopLevelAncestor();  
	    dashboard.card_layout.show(l_frame.getContentPane(), "Page Login");
		
	}
}
