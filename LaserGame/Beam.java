// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// LaserBeam Class

import java.awt.*;

public class Beam
{
	private double angle;
	private int startx;
	private int starty;
	private int baseDist;
	private int sideDist;
	private boolean passed;
	// Passed basically cuts down the cpu load when beam is being redrawn. After the first run
	//		passed is activated. If it is updated, it is shut down

	public Beam()
	{
		
		updateBeam();
		/*angle = cannonAngle;
		startx = endLoc.getHoriz();
		starty = endLoc.getVert();
		//cannonLoc = userLoc;
		baseDist = startLoc.getHoriz()-startx;
		sideDist = startLoc.getVert()-starty;*/
		System.out.println("Beam constructed");
	}
	
	/*public void updateBeamOffScreen()  //Updates to cannon position
	{
		angle = LaserGame.gun().getAngle();
		startx = LaserGame.gun().getEndLoc().getHoriz();
		starty = LaserGame.gun().getEndLoc().getVert();
		//cannonLoc = userLoc;
		baseDist = LaserGame.gun().getStartLoc().getHoriz()-startx;
		sideDist = LaserGame.gun().getStartLoc().getVert()-starty;		
	}*/
	
	public void updateBeam()  //Updates to cannon position
	{
		angle = LaserGame.gun().getAngle();
		startx = LaserGame.gun().getEndLoc().getHoriz();
		starty = LaserGame.gun().getEndLoc().getVert();
		//cannonLoc = userLoc;
		baseDist = LaserGame.gun().getStartLoc().getHoriz()-startx;
		sideDist = LaserGame.gun().getStartLoc().getVert()-starty;		
	}
	
	public boolean checkForHits()
	{
		/* What i need to do here is to get the height of the missile, and find the x value of
		 * the line at that altitude. Then I need to See if the x value is within the missile.
		 *
		 */
		 
		int appHeight = LaserGame.getAppletHeight(); // Height of the applet
		int missVert = LaserGame.nuke().getMissileLoc().getVert(); // Verticle value of the Missile
		int diam = LaserGame.nuke().getDiam(); // Diameter of the missile
		
		int endy = appHeight-(missVert+(diam/2)+(starty)); //calculates the height of the missile from the tip of the cannon
		int endx = (baseDist) - (int)((endy) / Math.tan(angle));
		
		
		System.out.println("Line: " + endx + " Nuke: " + LaserGame.nuke().getMissileLoc().getHoriz() + " - " 
								+ (LaserGame.nuke().getMissileLoc().getHoriz()+60));
		System.out.println("Y :" + endy);
		
		
		/* If the value of x at the height that y is currently at is less than the top left corner of the */
		if ((endx <= LaserGame.nuke().getMissileLoc().getHoriz()+LaserGame.nuke().getDiam()) && (endx >= LaserGame.nuke().getMissileLoc().getHoriz()))
		{
			return true;// Returns
		}
		
		return false;
	}
	
		
	
	public void paintBeam(Graphics g) // work on     // NEW
	{
		/*int xValue;
		int yValue;*/
		
		g.setColor(Color.yellow);
		
		int endx = (baseDist) - (int)(700 * Math.cos(angle));
		int endy = (sideDist) - (int)(700 * Math.sin(angle));
		
		/*System.out.println("start: (" + startx + "," + starty + ")");
		System.out.println("end: (" + endx + "," + endy + ")");*/
		
		
		//g.drawLine(startx, starty, endx, endy);
		g.drawLine(baseDist, sideDist, endx, endy);
	}
	
		
	
	public double getAngle()
	{
		return angle;
	}
	
	/*
	public int getHypLength()
	{
		return (int)(Math.sqrt((double)(baseDist*baseDist) + (double)(sideDist*sideDist)));
	}*/
}