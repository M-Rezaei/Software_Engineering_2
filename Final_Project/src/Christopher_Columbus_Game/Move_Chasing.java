package Christopher_Columbus_Game;
import java.awt.Point;

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/


public class Move_Chasing implements MoveBehavior
{
	Point piratGoalLocation;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	
	public Point Move(Point piratelocation)
	{		
		piratGoalLocation = OceanExplorer.ship.getShipLocation();

		int DistanceX = Math.abs(piratelocation.x - piratGoalLocation.x);
		int Distancey = Math.abs(piratelocation.y - piratGoalLocation.y);
				
		if(DistanceX>Distancey)
		{
			if(piratelocation.x - piratGoalLocation.x > 0)
			{
				if(0<piratelocation.x && OceanMap.getMap()[piratelocation.x-1][piratelocation.y]==false)
					piratelocation.x--;
			}
			else if (piratelocation.x - piratGoalLocation.x < 0)
			{
				if(piratelocation.x<GridX-1 && OceanMap.getMap()[piratelocation.x+1][piratelocation.y]==false)
					piratelocation.x++;
			}
		}
		else
		{
			if (piratelocation.y - piratGoalLocation.y > 0)
			{
				if(0<piratelocation.y && OceanMap.getMap()[piratelocation.x][piratelocation.y-1]==false)
					piratelocation.y--;
			}
			else if (piratelocation.y - piratGoalLocation.y < 0)
			{
				if(piratelocation.y<GridY-1 && OceanMap.getMap()[piratelocation.x][piratelocation.y+1]==false)
					piratelocation.y++;
			}
		}
		
		return piratelocation;
	}
	
	public static Point CHECKED_Move(Point piratelocation)
	{		
		if (piratelocation == null) 
			  throw new IllegalArgumentException("<<< It is Null. >>>");
		
		//piratGoalLocation = OceanExplorer.ship.getShipLocation();
		Point piratGoalLocationTest = new Point(5,5);  //Assume it is a new ship location.
		
		int DistanceX = Math.abs(piratelocation.x - piratGoalLocationTest.x);
		int Distancey = Math.abs(piratelocation.y - piratGoalLocationTest.y);
				
		if(DistanceX>Distancey)
		{
			if(piratelocation.x - piratGoalLocationTest.x > 0)
			{
				//if(0<piratelocation.x && OceanMap.getMap()[piratelocation.x-1][piratelocation.y]==false)
					piratelocation.x--;
			}
			else if (piratelocation.x - piratGoalLocationTest.x < 0)
			{
				//if(piratelocation.x<OceanExplorer.GridX-1 && OceanMap.getMap()[piratelocation.x+1][piratelocation.y]==false)
					piratelocation.x++;
			}
		}
		else
		{
			if (piratelocation.y - piratGoalLocationTest.y > 0)
			{
				//if(0<piratelocation.y && OceanMap.getMap()[piratelocation.x][piratelocation.y-1]==false)
					piratelocation.y--;
			}
			else if (piratelocation.y - piratGoalLocationTest.y < 0)
			{
				//if(piratelocation.y<OceanExplorer.GridY-1 && OceanMap.getMap()[piratelocation.x][piratelocation.y+1]==false)
					piratelocation.y++;
			}
		}
		
		return piratelocation;
	}
	
}
