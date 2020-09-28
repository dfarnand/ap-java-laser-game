// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// ScoreBoard Class

import java.util.Random;
import java.awt.*;

public class ScoreBoard
{
	private int hits;
	private int misses;
	
	public ScoreBoard()
	{
		hits = 0;
		misses = 0;
	}
	
	public void addHit()
	{
		hits++;
	}
	
	public void addMiss()
	{
		misses++;
		if (misses >= 5)
		{
			LaserGame.endGame();
		}
	}
	
	public void paintBoard(Graphics g)
	{
		g.setColor(Color.white);
		
		g.drawString(("Hits: " + hits + "   Misses: " + misses) , 10, LaserGame.getAppletHeight()-10);
	}
	
	public int getHits()
	{
		return hits;
	}
	
	/*
	public void endGame()
	{
		// Ends Game	
	}*/
}