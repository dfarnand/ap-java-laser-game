// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Missile Class

import java.util.Random;

public class Missile
{
	private Location loc;
	
	public Missile()
	{
		loc = randomLoc();
	}
	
	public void explode()
	{
		// BOOM!!
	}
	
	public void die()
	{
		// Missile Disappears
	}
	
	public void draw()
	{
		// Draws Missile
	}
	
	public Location getLoc()
	{
		return loc;
	}
	
		
	private Location randomLoc()
	{
		Random r = new Random();
		
		// Generates and returns random Location
		//int randomHoriz = r.nextInt(
			
		return new Location(2,3);
	}
}