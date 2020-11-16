package Christopher_Columbus_Game;
import java.awt.Point;
import java.util.Random;

/******************************************************************************

				<<< Christopher Columbus Game >>>
					Software Engineering (513)

		Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

public class Move_Patrolling implements MoveBehavior
{
	Point piratGoalLocation;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	Random rand = new Random();

	public Point Move(Point piratelocation)
	{
		piratGoalLocation = OceanExplorer.ship.getShipLocation();

		// Generate random number: 1=Up , 2=Left , 3=Down , 4=Right.
		int min = 1;
		int max = 4;
		int NextPlace = rand.nextInt((max - min) + 1) + min; //Generate random number inclusively between min and max
		
		if (NextPlace==1) // Up
		{
			if(0<piratelocation.y && OceanMap.getMap()[piratelocation.x][piratelocation.y-1]==false) 
				if(piratGoalLocation.x != piratelocation.x || (piratGoalLocation.x == piratelocation.x && piratGoalLocation.y != piratelocation.y)) 
					piratelocation.y--;	
		}
		else if (NextPlace==2) // Left
		{
			if(0<piratelocation.x && OceanMap.getMap()[piratelocation.x-1][piratelocation.y]==false)
				if(piratGoalLocation.y != piratelocation.y || (piratGoalLocation.y == piratelocation.y && piratGoalLocation.x != piratelocation.x)) 
					piratelocation.x--;	
		}
		else if (NextPlace==3) // Down
		{
			if(piratelocation.y<GridY-1 && OceanMap.getMap()[piratelocation.x][piratelocation.y+1]==false)
				if(piratGoalLocation.x != piratelocation.x || (piratGoalLocation.x == piratelocation.x && piratGoalLocation.y != piratelocation.y)) 
					piratelocation.y++;	
		}
		else if  (NextPlace==4)// Right
		{
			if(piratelocation.x<GridX-1 && OceanMap.getMap()[piratelocation.x+1][piratelocation.y]==false)
				if(piratGoalLocation.y != piratelocation.y || (piratGoalLocation.y == piratelocation.y && piratGoalLocation.x != piratelocation.x)) 
					piratelocation.x++;	
		}
		
		
		return piratelocation;
	}
}
