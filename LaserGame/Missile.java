// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Missile Class

import java.util.Random;
import java.awt.*;

public class Missile
{
	private static Location missileLoc;
	private final int DIAMETER; // Diameter of Missile
	private String message;
	//private Cannon gun;
	
	public Missile(/*Cannon userGun*/)
	{
		//gun = userGun;
		missileLoc = randomLoc();
		message = ("You're our last hope, Good Luck");
//		loser = false;
		DIAMETER = 60;
	}
	
	public void explode()
	{
		message = hitMessage();
		System.out.println("BOOOM!!!");
		LaserGame.score().addHit();
		LaserGame.setHit();
		//missileLoc = randomLoc();
		// BOOM!!
	}
	
	public void die()
	{
		message = missMessage();
		LaserGame.score().addMiss();
		LaserGame.setMiss();
	}
	
	public void newLoc()
	{
		missileLoc = randomLoc();
	}
	
	public void paintMissile(Graphics g)
	{
		g.setColor(randomColor());
		//g.setFont(new Font("w00t", PLAIN, 14));
		g.drawString(message , 10, 15);

		/*g.setColor(Color.red);
				
		g.fillOval(missileLoc.getHoriz(), missileLoc.getVert(),  DIAMETER, DIAMETER);
		//g.drawImage (missilePic, missileLoc.getHoriz(), missileLoc.getVert(), this);*/
	}
	
	public static Location getMissileLoc()
	{
		return missileLoc;
	}
	
	private Location randomLoc()
	{
		Random r = new Random();
		
		// Generates and returns random Location
		int randHoriz = r.nextInt(LaserGame.getAppletWidth()-60);//Makes sure missile is within window
		int randVert = r.nextInt(LaserGame.getAppletHeight()-(int)(LaserGame.getAppletHeight()*.2));
		// Does not allow Missile within the bottom 20% of the window
			
		return new Location(randHoriz,randVert);
	}
	
	public int getDiam()
	{
		return DIAMETER;
	}
	
	private int randomInt(int totalNumber)
	{
		Random r = new Random();
		
		// Generates and returns random Location
		int rand = r.nextInt(totalNumber);
		
		// Does not allow Missile within the bottom 20% of the window
			
		return rand;
	}
	
	private String missMessage() // gives you a message when you miss
	{
			
		switch (randomInt(22)) //gets random integer(for 22 cases)
		{		
			case 21: return("They just destroyed Tokyo! Shimatta!");
			case 20: return("NEIN!! Wir haben Berlin verloren!!");
			case 19: return("You bloody tosser, that was London!!");
			case 18: return("What are you doing? That was NYC!!");
			case 17: return("We just lost fricking San Francisco!!");
			case 16: return("Houston we have... Houston? Houston!?");
			case 15: return("...That was D.C.....");
			case 14: return("... How could you?"); // Shanghai
			case 13: return("Moscow... were those smart missiles?");
			case 12: return("Toronto!! Whats going oh, eh?");
			case 11: return("You let them hit Rochester!! You bastard!!");
			case 10: return("There goes Bahgdad (oh well)");
			case 9: return("Miami is toast!! (What are you doing up there?)");
			case 8: return("Orlando got fried!!!");
			case 7: return("Delhi... the poor cows ):");
			case 6: return("Little Rock, wtf?");
			case 5: return("That was Hong Kong, what the hell are you doing?");
			case 4: return("They got Hicksville!!");
			case 3: return("Nashville!!!!");
			case 2: return("There goes Casablanca!!!");
			case 1: return("NEIIN!!... warum, Munich, warum?");
			case 0: return("All of Australia!!? WTF, mates ^^");
		}
		
		return("You're horrible!!");
	}
	
	private String hitMessage() // gives you a message when you hit
	{
		
		switch (randomInt(14)) //gets random integer(for 22 cases)
		{		
			case 13: return("Nice shot kid!");
			case 12: return("Obi Wan has taught you well.");
			case 11: return("Nice one!");
			case 10: return("w00t");
			case 9: return("Yeah, baby, yeah!");
			case 8: return("Target Eliminated");
			case 7: return("The force is strong with this one");
			case 6: return("He is beginning to beleive..."); 
			case 4: return("Hey hey hey!");
			case 3: return("All their base are belong to us!");
			case 2: return("Rock on!");
			case 1: return("Another one bites the dust!");
			case 0: return("We... are the Champions!!");
		}
		
		return("You're AWESOME!!");
	}
	
	private Color randomColor()
	{
		Random r = new Random();
		return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)); // Returns a completely random color
	}
	
	public Location moveDown()
	{
		missileLoc.setVert(missileLoc.getVert()+8);
		return missileLoc;
	}
}