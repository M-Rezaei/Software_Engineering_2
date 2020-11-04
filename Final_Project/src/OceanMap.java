import java.awt.Point;
import java.util.Random;

/******************************************************************************

                 <<< Christopher Columbus Game >>>
                     Software Engineering (513)

        Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

// The OceanMap Class: Determines the Island Location on the Sea:
public class OceanMap {
	
	boolean[][] SeaGrid;
	Point currentLocation;
	
	OceanMap(int x, int y, int island)
	{
		SeaGrid = new boolean[x][y];
				
		for(int i=0; i<x; i++)
			for (int j=0; j<y; j++)
				SeaGrid[i][j] = false;
		

		Random rand = new Random();
		int randX;
		int randY;
		
		for(int i=0; i<island; i++)
		{
			randX = rand.nextInt(x);
			do {
			randY = rand.nextInt(y);
			}while(randX==0 && randY==0);
			
			SeaGrid[randX][randY] = true;

		}
	}
	
	public boolean[][] getMap()
	{
		return SeaGrid;
	}
	
	
}
