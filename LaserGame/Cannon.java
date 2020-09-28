// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Cannon Class

import java.awt.*;

public class Cannon
{
	private double angle;
	private Location loc;
	private int length;
	private boolean shooting; //Is it shooting right now??
	//private Beam laser;
	private int endx; // endpoints for cannon
	private int endy;
	
	
	public Cannon(double userAngle, Location userLoc, int userLength /*,Beam userLaser*/)
	{
		angle = userAngle;
		loc = userLoc;
		length = userLength;
		shooting = false; // not shooting yet
		endx =  (int)(length * Math.cos(angle));
		endy =  (int)(Math.sqrt((double)(length*length) - (double)(endx*endx)));
		
	}
	
	public void shoot()
	{
		System.out.println("Launch ze Missile!!");
		System.out.println("cannon: (" + endx + "," + endy + ")");
		//LaserGame.laser() = new Beam(angle, new Location(endx, endy), loc); Not created here anymore
		
		LaserGame.laser().updateBeam(); // Sets up for current position
				
		shooting = true; // Now we're talking
		
		if(LaserGame.laser().checkForHits())
		{
			LaserGame.nuke().explode(); // If its a hit, it exlodes
		}
		else
		{
			LaserGame.nuke().die(); // It just dies on screen with a miss, it really touches down
		}
	}
	
	public void paintCannon(Graphics g)
	{
		g.setColor  (Color.white);
		
		endx =  (int)(length * Math.cos(angle));
		endy =  (int)(Math.sqrt((double)(length*length) - (double)(endx*endx)));

		
		g.drawLine ((loc.getHoriz()), loc.getVert(), ((loc.getHoriz())-endx), (loc.getVert()-endy));
		g.fillOval(loc.getHoriz()-10, loc.getVert()-10,  20, 20);
		g.fillOval((loc.getHoriz()-endx)-5, (loc.getVert()-endy)-5,  10, 10);
		
		if (shooting)
		{
			LaserGame.laser().paintBeam(g);
			
			/*
			try
			{
				Thread.sleep (1000); // Wait .1 Seconds
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}*/
			//shooting = false; // only paint once per shot
			
			
		}
		
    }
    
    
	
	public Location getStartLoc()
	{
		return loc;
	}
	
	public Location getEndLoc()
	{
		return new Location (endx,endy);
	}
	
	public double getAngle()
	{
		return angle;
	}	
	
	public boolean shooting()
	{
		return shooting;
	}
	
	public void noShoot()
	{
		shooting = false;
	}
	
	public void rotate(double degrees)
	{
		if (angle >= (Math.PI-(Math.PI/36)) && (degrees > 0))
			angle = Math.PI-(Math.PI/36);
		else if ((angle <= 0+(Math.PI/36)) && (degrees < 0))
			angle = 0+(Math.PI/36);
		else
			angle += degrees; // Rotating
		
	//	System.out.println("Current Angle: " + angle);
	}
}