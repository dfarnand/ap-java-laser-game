// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Cannon Class

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Cannon extends JApplet
{
	private int angle;
	private Location loc;
	
	public Cannon()
	{
		angle = 90;
		loc = new Location(7*30, 20*30); 
		// Each dimension must be multiplied by 30 to interface onto grid
	}
	
	public Cannon(int userAngle, Location userLoc)
	{
		angle = userAngle;
		loc = userLoc;
	}
	
	public void rotate(boolean right)
	{
		// rotates 5 degrees left or right
	}
	
	public void shoot()
	{
		// Shoots
	}
	/*
	public void paint(Graphics g)
	{
		Graphics2D cannonPic = (Graphics2D) g;
        cannonPic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Dimension d = getSize();
        
        double xValue = 35 * Math.cos((double) angle);
        double yValue = Math.sqrt(Math.pow(35.0, 2.0) - Math.pow(xValue, 2.0));
        
        cannonPic.drawLine(loc.getHoriz(), loc.getVert(), loc.getHoriz() + (int)xValue, loc.getVert() + (int)yValue);
        
    }*/
    
    
	
	public Location getLoc()
	{
		return loc;
	}
	
	
}