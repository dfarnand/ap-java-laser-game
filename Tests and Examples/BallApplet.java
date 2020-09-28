import java.applet.*;
import java.awt.*;

public class BallApplet extends Applet implements Runnable
{
	// Initialisierung der Variablen
	private Image dbImage; 
	private Graphics dbg; 
	private final double XSIZE = 420;
	private final double YSIZE = 600;
	private double angle = 0;

	public void init()
	{
		setBackground (Color.blue);
	}

	public void start ()
	{
		// Schaffen eines neuen Threads, in dem das Spiel läuft
		Thread th = new Thread (this);
		// Starten des Threads
		th.start ();
	}

	public void stop()
	{

	}

	public void destroy()
	{

	}

	public void run ()
	{
		// Erniedrigen der ThreadPriority um zeichnen zu erleichtern
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

		// Solange true ist läuft der Thread weiter
		while (true)
		{
			// Verändern der x- Koordinate
			
			if (angle > 180)
				angle = 0;
			else 
				angle++;

			// Neuzeichnen des Applets
			repaint();

			try
			{
				// Stoppen des Threads für in Klammern angegebene Millisekunden
				Thread.sleep (1000);
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}

			// Zurücksetzen der ThreadPriority auf Maximalwert
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}


	public void paint (Graphics g)
	{
		g.setColor  (Color.red);
		/*
		for (int i = 0; i <= YSIZE; i+=30)
		{
			g.drawLine(0, i, XSIZE, i);
		}
		
		for (int j = 0; j <= XSIZE; j+=30)
		{
			g.drawLine(j, 0, j, YSIZE);
		}*/
		
		/*
		int endx = (int) (35 * Math.cos((double) angle));
		int endy = (int) (Math.sqrt(Math.pow(35.0, 2.0) - Math.pow(endx, 2.0)));
		g.drawLine (XSIZE/2, YSIZE, (XSIZE/2)-endx, YSIZE-endy);
		*/
		
		double endx =  (35.0 * Math.cos(angle));
		double endy =  (Math.sqrt(Math.pow(50.0, 2.0) - Math.pow(endx, 2.0)));
		
		g.drawString(("First pts: (" + (XSIZE/2) + "," + (YSIZE) + ")") , 50, 25);
		g.drawString(("End pts: (" + (endx) + "," + (endy) + ")") , 50, 50);
		
		if(angle>90.0)
			g.drawLine ((int)(XSIZE/2.0), (int)YSIZE, (int)((XSIZE/2.0)+endx), (int)(YSIZE-endy));
		else if(angle<90.0)
			g.drawLine ((int)(XSIZE/2.0), (int)YSIZE, (int)((XSIZE/2.0)-endx), (int)(YSIZE-endy));
		else if(angle == 90.0)
			g.drawLine ((int)(XSIZE/2.0), (int)YSIZE, (int)(XSIZE/2.0), (int)(YSIZE-50.0));
		
	}
	
	public void update (Graphics g) 
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

}
