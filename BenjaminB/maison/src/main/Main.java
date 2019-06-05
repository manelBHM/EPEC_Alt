package main;
import java.awt.*;
import java.applet.*;

public class Main extends Applet{
	public void init()
	{
		
	}
	public void paint(Graphics g) {
		//Contour maison !!!
		g.drawRect(20, 120, 500, 250);
		//Fenetres de gauche !!!
		g.drawRect(50, 150, 50, 50);
		g.drawRect(50, 201, 50, 50);
		g.drawRect(101, 150, 50, 50);
		g.drawRect(101, 201, 50, 50);
		//Fenetres de droite
		g.drawRect(370, 150, 50, 50);
		g.drawRect(370, 201, 50, 50);
		g.drawRect(421, 150, 50, 50);
		g.drawRect(421, 201, 50, 50);
		// Porte !!!
		g.drawRect(235, 270, 50, 100);
		g.drawOval(250, 320, 5, 5);
		// Toit !!!
		g.drawLine(10,120,300,35);  
		g.drawLine(520,120,300,35);  
		g.drawLine(520,120,10,120);  
		//cheminé
		g.drawRect(521, 70, 50, 300);
		g.drawString("Welcome to SIMPLON ",205, 250);  
	}
}
