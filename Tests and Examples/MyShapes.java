import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class MyShapes extends JApplet
{
	public static void main(String [] args) 
    {/*
        JFrame frame = new JFrame("Star");
        frame.addWindowListener(new WindowAdapter() 
        						{
									public void windowClosing(WindowEvent e) 
									{
										System.exit(0);
									}
       							});
        
        JApplet applet = new MyShapes();
        frame.getContentPane().add("Center", applet);
        applet.init(); // why does it have to be applet.?
        frame.pack();
        frame.setSize(new Dimension(429,628));
        frame.show();*/
        create();
    }
    
    private static void create()
    {
    	        JFrame frame = new JFrame("Star");
        frame.addWindowListener(new WindowAdapter() 
        						{
									public void windowClosing(WindowEvent e) 
									{
										System.exit(0);
									}
       							});
        
        JApplet applet = new MyShapes();
        frame.getContentPane().add("Center", applet);
        applet.init(); // why does it have to be applet.?
        frame.pack();
        frame.setSize(new Dimension(429,628));
        frame.show();
    }
    
	public void init() 
	{
        //Initialize drawing colors
        setBackground(Color.cyan);
        setForeground(Color.green);
    }
    
    /*
	public void paint(Graphics g) 
    {
    	Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        
		g2.setPaint(Color.blue);
     	for (int x = 0; x <= 420; x = x+30)
     	{
			g2.drawLine(x, 0, x, 600);
    	}
    	
    	g2.setPaint(Color.darkGray);
     	for (int y = 0; y <= 600; y = y+30)
     	{
     		if (y >= 500)
     		{
     			g2.setPaint(Color.pink);
     		}
			g2.drawLine(0, y, 420, y);
    	}
    	
    	//5, 10  6, 13
    	
    	int horiz1 = 5;
    	int vert1 = 10;
    	
    	g2.setColor(Color.black);
    	g2.fillOval(horiz1 * 30, vert1 * 30, 30, 30);
    	
    }*/
}