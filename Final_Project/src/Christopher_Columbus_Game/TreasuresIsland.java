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
public class TreasuresIsland
{
	
	Point treasureGoalLocation;
	Point treasureIslandLocaction;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;

	Random rand = new Random();
	int RandX;
	int RandY;
	
	public TreasuresIsland()
	{	
		do
		{
			RandX = rand.nextInt(GridX);
			RandY = rand.nextInt(GridY);
		}while(OceanMap.getMap()[RandX][RandY]==true);
		
		treasureIslandLocaction = new Point(RandX,RandY); 
		OceanMap.SeaGrid[RandX][RandY] = true;
		
		Image TreasureIslandImage = new Image("Photos\\TreasureIsland.png",Scale,Scale,true,true);
		ImageView TreasureIslandView = new ImageView(TreasureIslandImage);
		TreasureIslandView.setX(treasureIslandLocaction.x * Scale);
		TreasureIslandView.setY(treasureIslandLocaction.y * Scale);
		
		OceanExplorer.pane.getChildren().add(TreasureIslandView);
	}
	
	public Point getTreasureIslandLocaction()
	{
		return treasureIslandLocaction;
	}
	
}
