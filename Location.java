// Dan Farnand
// Strategic Missile Defense
// 5/13/04
// Location Class

public class Location
{
	private int horiz;
	private int vert;
	
	public Location(int x, int y)
	{
		horiz = x;
		vert = y;
	}
	
	public int getHoriz()
	{
		return horiz;
	}
	
	public int getVert()
	{
		return vert;
	}
	
	public void setHoriz(int userHoriz)
	{
		horiz = userHoriz;
	}
	
	public void setVert(int userVert)
	{
		vert = userVert;
	}
	
}
	
