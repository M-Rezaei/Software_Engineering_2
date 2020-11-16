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

// The PirateIsland Class: Determines the Pirate Island Location on the Sea:
public class PirateIsland
{
	
	Point piratGoalLocation;
	Point pirateIslandLocaction;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;

	Random rand = new Random();
	int RandX;
	int RandY;
	
	public PirateIsland()
	{		
		do
		{
			RandX = rand.nextInt(GridX);
			RandY = rand.nextInt(GridY);
		}while(OceanMap.getMap()[RandX][RandY]==true);
		
		pirateIslandLocaction = new Point(RandX,RandY); 
		OceanMap.SeaGrid[RandX][RandY] = true;
		
		Image PirateIslandImage = new Image("Photos\\PirateIsland.png",Scale,Scale,true,true);
		ImageView PirateIslandView = new ImageView(PirateIslandImage);
		PirateIslandView.setX(pirateIslandLocaction.x * Scale);
		PirateIslandView.setY(pirateIslandLocaction.y * Scale);
		
		OceanExplorer.pane.getChildren().add(PirateIslandView);
		
	}
	
	public Point getpirateIslandLocaction()
	{
		return pirateIslandLocaction;
	}
	
}
