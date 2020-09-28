// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Cannon Class
// w00t w00t

import java.awt.*;
import java.applet.*;
import javax.swing.*;


public class LaserGame extends Applet implements Runnable
{
	
	private Image dbImage; 
	private Graphics dbg; 
	
	 // = null; // I think this may let Beam compile
	private static Cannon gun;
	private static ScoreBoard score;
	private static Missile nuke;
	private static Beam laser;
	private static boolean endGameMessage;
	private static boolean endGame; // game continues as long as false
	private static int width; // applet width
	private static int height; // applet height
	Image backImage; 
	Image gameOver;
	Image missilePic;
	Image deBoom;
	Image airBoom;
	//AudioClip music; 
	private static boolean missed;
	private static boolean explode;
	private static boolean fired;
	private static boolean hit;

//INIT*****************************************************************************************
	
	public void init() 
	{
		this.findAppletSize();
		
		gun = new Cannon((Math.PI/2), new Location(width/2, height), 50/*, laser*/); // May need parameters
		score = new ScoreBoard();
		nuke = new Missile();
		laser = new Beam();
		endGame = false;
		endGameMessage = false;
		missed = false;
		explode = false;
		fired = false;
		hit = false;
		
		//setBackground (Color.gray);
   		setBackground (Color.black); // actual sky color
   		//(switching colors are to give a clear way to tell if class file actually recompiled.)
   		
   		// load file sky.jpg, gameover.jpg
		backImage = getImage (getCodeBase (), "sky.jpg"); 
		gameOver = getImage (getCodeBase (), "gameover.jpg"); 
		missilePic = getImage (getCodeBase(), "nuke.gif");
		deBoom = getImage (getCodeBase(), "deBoom.gif");
		airBoom = getImage (getCodeBase(), "airBoom.gif");
		
		//music = getAudioClip (getCodeBase(), "hawaii.mp3"); 




	}
	
//START***************************************************************************************
	
	public void start ()
	{
		Thread th = new Thread (this);
		th.start ();
	}
	
//RUN******************************************************************************************
	
	public void run ()
	{
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		//music.play();

		while (!endGame)
		{
			if (fired)
			{
				if (missed)
				{
					for (int i = nuke.getMissileLoc().getVert(); i <= height; i=i+8)
					{
						nuke.moveDown();
						repaint();
						
						try
						{
							Thread.sleep (5);
						} catch (InterruptedException ex) {} // does nothing
					}
					
					explode = true;
					
					repaint() ;
					
					try
					{
						Thread.sleep (600);
					} catch (InterruptedException ex) {} // does nothing
					
					explode = false;
							
					missed = false;
				}
				else
				{
					hit = true;
					repaint();
					try
					{
						Thread.sleep (600);
					} catch (InterruptedException ex) {} // does nothing
					
					hit = false;
				}
				
				fired = false;
				nuke.newLoc();
			}
			
						
			repaint();

			try
			{
				Thread.sleep (10);
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}
			
			

			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		} 
	}
	
//PAINT****************************************************************************************
	
	public void paint (Graphics g)
	{
		// drawing the image: g.drawImage (name, x- value, y - value, frame) 
		g.drawImage (backImage, 0, 0, this); 
		
		gun.paintCannon(g);
		nuke.paintMissile(g);
		
		/* Ok, whats going to happen here is that the missile is going to be drawn just like below once
		 * a while, but once in a while (specifically when it is missed, it will call another method
		 * in this class. How it will know will be a boolean variable that will allow it to enter the
		 * conditinal once (it will be switched back at the end.) inside the conditional will be a 
		 * loop that will bring the missile to the bottom of the screen.*/
		
		g.drawImage (missilePic, nuke.getMissileLoc().getHoriz(), nuke.getMissileLoc().getVert(), this);
		
		if(explode)
		{
			g.drawImage (deBoom, nuke.getMissileLoc().getHoriz(), height-80, this);
		}
		if(hit)
		{
			g.drawImage (airBoom, nuke.getMissileLoc().getHoriz(), nuke.getMissileLoc().getVert(), this);
		}
		
		score.paintBoard(g);
		
		if (endGameMessage)
		{
			g.drawImage (gameOver, 0, 0, this); 
			g.setColor(Color.white);
			g.drawString(("Final Score: " + score.getHits()) , 170, 400);
		}
		/*
		if (gun.shooting())
		{
			for(int i=0; i<laser.getHypLength(); i+=5)
			{				
				laser.paintOval(i, g);
				
				repaint();
				
				try
				{
					Thread.sleep (100); // Wait .1 Seconds
				}
				catch (InterruptedException ex)
				{
					// do nothing
				}
			}
		}*/
	}
	
//UPDATE***************************************************************************************
	
	public void update (Graphics g) // Double Buffering
	{ 
		// initialize buffer 
		if (dbImage == null) 
		{ 
			dbImage = createImage (this.getSize().width, this.getSize().height); 
			dbg = dbImage.getGraphics (); 
		} 

		// clear screen in background 
		dbg.setColor (getBackground ()); 
		dbg.fillRect (0, 0, this.getSize().width, this.getSize().height); 

		// draw elements in background 
		dbg.setColor (getForeground()); 
		paint (dbg); 

		// draw image on the screen 
		g.drawImage (dbImage, 0, 0, this); 
	} 
	
//KEYDOWN**************************************************************************************
	
	public boolean keyDown (Event e, int key) 
	{ 
		if (!fired)
		{
			// user presses left cursor key 
			if (key == Event.LEFT) 
			{ 	
				gun().noShoot();
				gun.rotate((-1*Math.PI/36)); // is not to the right
			} 
			
			// user presses right cursor key 
			else if (key == Event.RIGHT) 
			{ 
				gun().noShoot();
				gun.rotate(Math.PI/36); // is to the right
			} 
			else if (key == 32) 
			{ 
				gun().noShoot();
				gun.shoot();	
			}
			else 
			{ 
				/* Additionally the method prints out the ASCII - value if an other key is pressed. This is not necessary but a possibility for you to test which value a key has.*/ 
				System.out.println ("Character: " + (char)key + " Integer Value: " + key); 
	
			} 
		}

		// DON'T FORGET (although it has no meaning here) 
		return true; 
	} 
	
//SHOOTING**************************************************************************************
	
	private void shooting()
	{
		
		gun.shoot();
		
		//gun().changeShoot();
		/*
		try
		{
			Thread.sleep (100); // Wait .1 Seconds
		}
		catch (InterruptedException ex)
		{
			// do nothing
		}
		
		gun().changeShoot();		
		/*
		if(laser().checkForHits())
		{
			nuke().explode(); // If its a hit, it exlodes
		}
		else
		{
			nuke().die(); // It just dies on screen with a miss, it really touches down
		}*/
	}
	
//FIND*APPLET*SIZE******************************************************************************
	
	private void findAppletSize()
	{
		Dimension appletSize = this.getSize();
		width = appletSize.width;
   		height = appletSize.height;
	}
	
//GET*APPLET*HEIGHT******************************************************************************
	
	public static int getAppletHeight()
	{
		return height;
	}
	
//GET*APPLET*WIDTH*********************************************************************************************
	
	public static int getAppletWidth()
	{
		return width;
	}
	
//END*GAME*********************************************************************************************
	
	public static void endGame()
	{
		endGameMessage = true;
	}
	
//GUN*********************************************************************************************
	
	public static Cannon gun() // Returns the Cannon object
	{
		return gun;
	}
	
//SCORE*********************************************************************************************
	
	public static ScoreBoard score() //Returns the Scoreboard object
	{
		return score;
	}
	
//NUKE*********************************************************************************************
	
	public static Missile nuke()
	{
		return nuke;
	}
	
//NUKE*********************************************************************************************
	
	public static Beam laser()
	{
		return laser;
	}
	
	public static void setMiss()
	{
		fired = true;
		missed = true;
	}
	
	public static void setHit()
	{
		fired = true;
		hit = true;
	}
		
}
