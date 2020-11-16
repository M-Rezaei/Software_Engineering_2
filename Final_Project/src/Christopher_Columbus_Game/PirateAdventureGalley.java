package Christopher_Columbus_Game;
import java.awt.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/


public class PirateAdventureGalley extends Pirate implements Observer
{
	ImageView PirateShipImageView;

	public PirateAdventureGalley()
	{	
		MoveBehavior = new Move_Patrolling();
		
		OceanExplorer.ship.registerObserver(this);

		Image PirateShipImage = new Image("Photos\\PirateAdventureGalley.png",Scale,Scale,true,true);
		PirateShipImageView = new ImageView(PirateShipImage);					
		
		do
		{
			RandX = rand.nextInt(GridX);
			RandY = rand.nextInt(GridY);
		}while(OceanMap.getMap()[RandX][RandY]==true || (OceanExplorer.ship.getShipLocation().x == RandX && OceanExplorer.ship.getShipLocation().y == RandY ));
		
		piratelocation = new Point(RandX,RandY); 
		
		PirateShipImageView.setX(piratelocation.x * Scale);
		PirateShipImageView.setY(piratelocation.y * Scale);
		
		OceanExplorer.pane.getChildren().add(PirateShipImageView);
	}
	
	@Override
	public void update(Ship ship)
	{
		if(ship instanceof Ship)
		{	
			piratelocation = MoveBehavior.Move(piratelocation);
			
			//Founding Ship:
			if(piratelocation.x == OceanExplorer.ship.getShipLocation().x-1 && piratelocation.y == OceanExplorer.ship.getShipLocation().y)
				setMoveBehavior(new Move_Chasing());
			if(piratelocation.x == OceanExplorer.ship.getShipLocation().x+1 && piratelocation.y == OceanExplorer.ship.getShipLocation().y)
				setMoveBehavior(new Move_Chasing());
			if(piratelocation.x == OceanExplorer.ship.getShipLocation().x && piratelocation.y == OceanExplorer.ship.getShipLocation().y-1)
				setMoveBehavior(new Move_Chasing());
			if(piratelocation.x == OceanExplorer.ship.getShipLocation().x && piratelocation.y == OceanExplorer.ship.getShipLocation().y+1)
				setMoveBehavior(new Move_Chasing());
			
		}
	}
	
	public void setPirateLocation(int x, int y)
	{
		piratelocation.x = x;
		piratelocation.y = y;
		
		PirateShipImageView.setX(piratelocation.x * Scale);
		PirateShipImageView.setY(piratelocation.y * Scale);
	}
}
