package Christopher_Columbus_Game;
import java.awt.Point;
import java.util.Random;

/******************************************************************************

                    <<< Christopher Columbus Game >>>
                        Software Engineering (513)

            Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

//Pirate Ship Class:
public class Pirate
{
	MoveBehavior MoveBehavior;

	Point piratelocation;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	
	Random rand = new Random();
	int RandX;
	int RandY;
		
	public Pirate()
	{	
	}
	
	public void setMoveBehavior(MoveBehavior moveBehavior)
	{
		MoveBehavior = moveBehavior;
	}

	
	public Point getPirateLocation()
	{
		return piratelocation;
	}
	
}
