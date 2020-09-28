// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Sky Class

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Sky extends JApplet
{
	public static Cannon gun;
	public static ScoreBoard score;
	public static Missile nuke;
	private static Graphics2D g2;
	private static JFrame aFrame;
	private static JApplet applet;
	private static Location loc = new Location(7*30, 20*30);
	
	
	
	public static void initialize()
	{
		create();
		// each may need parameters
		gun = new Cannon(); // May need parameters
		score = new ScoreBoard();
		nuke = new Missile();
	}
	
    private static void create()
    {
    	aFrame = new JFrame("..::Strategic Missile Defense::..");
        aFrame.addWindowListener(new WindowAdapter() 
        						{
									public void windowClosing(WindowEvent e) 
									{
										System.exit(0);
									}
       							});
        
        applet = new Sky();
        aFrame.getContentPane().add("Center", applet);
        applet.init(); // why does it have to be applet.?
        aFrame.pack();
        aFrame.setSize(new Dimension(429,628));
        aFrame.show();
    }
    
	public void init() 
	{
        //Initialize drawing colors
        setBackground(new Color(128,255,255));
        setForeground(Color.black);
    }
    
    
    public void paint(Graphics g)
    {
    	g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        
        /*
        double xValue = 35 * Math.cos((double) 15);
        double yValue = Math.sqrt(Math.pow(35.0, 2.0) - Math.pow(xValue, 2.0));
        
        g2.drawLine(loc.getHoriz(), loc.getVert(), loc.getHoriz() + (int)xValue, loc.getVert() + (int)yValue);*/
    }
    
    public static void paint(Graphics g, int angle, Location loc)
    {
    	g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Dimension d = getSize();
        
        double xValue = 35 * Math.cos((double) 15);
        double yValue = Math.sqrt(Math.pow(35.0, 2.0) - Math.pow(xValue, 2.0));
        
        g2.drawLine(loc.getHoriz(), loc.getVert(), loc.getHoriz() + (int)xValue, loc.getVert() + (int)yValue);
        System.out.println("drawing line?");
    }
    
    public static void draw()
    {
    	aFrame.show();
    }
    	
    public static void drawEnv(int gunAngle, Location gunLoc)
    {
    	draw();
    	paint(g2, gunAngle, gunLoc);
    	System.out.println("wtf?");
    	
    
    	
    }
    /*
   	private static void paintCannon(int angle, Location loc)
	{
		double xValue = 35 * Math.cos((double) angle);
        double yValue = Math.sqrt(Math.pow(35.0, 2.0) - Math.pow(xValue, 2.0));
        
        g2.drawLine(loc.getHoriz(), loc.getVert(), loc.getHoriz() + (int)xValue, loc.getVert() + (int)yValue);
    }*/
    
    
}
	
	
		
	
	