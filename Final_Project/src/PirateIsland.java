import java.awt.Point;
import java.util.Random;

// The PirateIsland Class: Determines the Pirate Island Location on the Sea:
public class PirateIsland {
	
	Point piratGoalLocation;
	Point pirateIslandLocaction;
	int Gridx;
	int Gridy;
	boolean[][] oceangrid;
	Random rand = new Random();
	int RandX;
	int RandY;
	
	public PirateIsland(int GridX, int GridY, boolean[][] oceanGrid)
	{
		Gridx=GridX;
		Gridy=GridY;
		oceangrid=oceanGrid;
		
		do
		{
			RandX = rand.nextInt(Gridx);
			RandY = rand.nextInt(Gridy);
		}while(oceangrid[RandX][RandY]==true);
		
		pirateIslandLocaction = new Point(RandX,RandY); 
		oceanGrid[RandX][RandY] = true;
	}
	
	public Point getpirateIslandLocaction()
	{
		return pirateIslandLocaction;
	}
	
}
