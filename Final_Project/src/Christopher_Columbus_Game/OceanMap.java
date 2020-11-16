package Christopher_Columbus_Game;
import java.awt.Point;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/******************************************************************************

                 <<< Christopher Columbus Game >>>
                     Software Engineering (513)

        Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

// The OceanMap Class: Determines the Island Location on the Sea:
public class OceanMap
{
	
	static boolean[][] SeaGrid;
	Point currentLocation;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	int Island = OceanExplorer.Island;
	
	private static OceanMap uniqueInstance;
	
	private OceanMap()
	{
		
		Image OceanImage = new Image("Photos\\Ocean.jpg",Scale*GridX,Scale*GridY,true,true);
		ImageView OceanView = new ImageView(OceanImage);
		OceanView.setX(0);
		OceanView.setY(0);
		OceanExplorer.pane.getChildren().add(OceanView);	
		
		
		SeaGrid = new boolean[GridX][GridY];
				
		for(int i=0; i<GridX; i++)
			for (int j=0; j<GridY; j++)
				SeaGrid[i][j] = false;
		

		Random rand = new Random();
		int randX;
		int randY;
		
		for(int i=0; i<Island; i++)
		{
			randX = rand.nextInt(GridX);
			do {
			randY = rand.nextInt(GridY);
			}while(randX==0 && randY==0);
			
			SeaGrid[randX][randY] = true;

		}
		
		Image IslandImage = new Image("Photos\\Island.png",Scale,Scale,true,true);

		for(int x = 0; x < GridX; x++)
		{
			for(int y = 0; y < GridY; y++)
			{
				if (OceanMap.getMap()[x][y]==true)
				{
					ImageView IslandView = new ImageView(IslandImage);
					IslandView.setX(x * Scale);
					IslandView.setY(y * Scale);
					OceanExplorer.pane.getChildren().add(IslandView);	
				}
			}
		}
		
		
	}
	
	public static OceanMap getInstance()
	{
		if (uniqueInstance == null)
		{
			uniqueInstance = new OceanMap();
		}
		return uniqueInstance;
		
	}
	
	public static void clear()
	  {
		uniqueInstance = null;
	  }
	
	public static boolean[][] getMap()
	{
		return SeaGrid;
	}
	
	
}
