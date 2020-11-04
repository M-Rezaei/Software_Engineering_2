import java.awt.Point;
import java.util.Random;

/******************************************************************************

                  <<< Christopher Columbus Game >>>
                      Software Engineering (513)

          Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

// The PirateIsland Class: Determines the Pirate Island Location on the Sea:
public class TreasureIsland2 {
	
	Point treasureGoalLocation;
	Point treasureIslandLocaction;
	int Gridx;
	int Gridy;
	boolean[][] oceangrid;
	Random rand = new Random();
	int RandX;
	int RandY;
	
	public TreasureIsland2(int GridX, int GridY, boolean[][] oceanGrid)
	{
		Gridx=GridX;
		Gridy=GridY;
		oceangrid=oceanGrid;
		
		do
		{
			RandX = rand.nextInt(Gridx);
			RandY = rand.nextInt(Gridy);
		}while(oceangrid[RandX][RandY]==true);
		
		treasureIslandLocaction = new Point(RandX,RandY); 
		oceanGrid[RandX][RandY] = true;
	}
	
	public Point getTreasureIslandLocaction()
	{
		return treasureIslandLocaction;
	}
	
}
