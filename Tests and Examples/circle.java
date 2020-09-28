1: public class circle extends java.applet.Applet {
2:    private int mouseX, mouseY;
3:    private boolean mouseclicked = false;
4:
5:	  public void init()  {
6:		setBackground(Color.magenta);
7:	  }
8:
9:   public boolean mouseDown(Event e, int x, int y ) {
10:       mouseX=x; mouseY=y;
11:       mouseclicked = true;
12:       repaint();
13:       return true;
14:   }
15:
16:    public void paint( Graphics g ) {
17:       g.setColor(Color.blue);
18:       if (mouseclicked) {
19:           g.fillOval(mouseX, mouseY, 10, 10);
20:           mouseclicked = false;
21:       }
22:   }    
23:}
