package com.issamdrmas;

import java.awt.* ;
import java.awt.event.* ;

public class Home extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Home() {
		setBackground(Color.cyan);
		setTitle("Ma House");
		setSize(450,350);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
	}
	
	public void paint(Graphics g) {
		    g.drawLine(50,300,375,300);            //  Line 1   Flooring of the house
		    g.drawLine(80,300,80,150);             //  Line 2   Left wall of outer house
		    g.drawLine(200,300,200,150); 	       //  Line 3   Right wall of outer house		
		    g.drawLine(50,170,140,110); 	       //  Line 4   Left inclination of the roof		
		    g.drawLine(140,110,230,170);           //  Line 5   Right inclination of the roof	
		  	                                       //  to draw entrance(door frame)
		    g.drawLine(110,220,110,300);	       //  Line 6   Entrance left	
		    g.drawLine(170,220,170,300); 	       //  Line 7   Entrance right
		    g.drawLine(110,220,170,220); 	       //  Line 8   Entrance top
			                                       //  to draw the man
		    g.drawLine(320,280,300,300); 	       //  Line 9    Left leg
		    g.drawLine(320,280,340,300); 	       //  Line 10   Right leg
		    g.drawLine(320,280,320,250); 	       //  Line 11   Body
		    g.drawLine(300,270,320,250); 	       //  Line 12   Left hand
		    g.drawLine(340,270,320,250); 	       //  Line 13   Right hand
		    g.drawOval(310,230,20,20);             //  Head
		
	}
	
	public static void main(String[] args) {
		new Home();
	}


}
