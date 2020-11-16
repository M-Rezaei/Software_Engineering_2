package Christopher_Columbus_Game;
import java.awt.Point;
import java.util.Random;
import javafx.scene.image.ImageView;

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

public class WhirlpoolDecoratorCrazy extends WhirlpoolDecorator
{
	Point decorateWhirlpoolLocation;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	Random rand = new Random();
	int RandX;
	int RandY;
	
	public WhirlpoolDecoratorCrazy(Whirlpool decorateWhirlpool)
	{
		super(decorateWhirlpool);
	}
	
	@Override
	public void Creator()
	{
		decorateWhirlpool.Creator();
        setCrazy();
	}

	private void setCrazy()
	{
		decorateWhirlpoolLocation = InitialLocation();
		
		OceanExplorer.pane.getChildren().remove(decorateWhirlpool.getWhirlpoolImageView());
		
		WhirlpoolCrazyImageView = decorateWhirlpool.UploadImage("Photos\\WhirlpoolCrazy.png", 2*Scale);
		
		WhirlpoolCrazyImageView.setX(decorateWhirlpoolLocation.x * Scale);
		WhirlpoolCrazyImageView.setY(decorateWhirlpoolLocation.y * Scale);
		OceanExplorer.pane.getChildren().add(WhirlpoolCrazyImageView);
		
	}

	@Override
	public Point getWhirlpoollocation()
	{
		return decorateWhirlpoolLocation;
	}

	@Override
	public ImageView getWhirlpoolImageView()
	{
		return WhirlpoolCrazyImageView;
	}

	@Override
	public Point InitialLocation()
	{
		Point InitialWhirlpoollocation;
		int counter=0;
		do
		{
			RandX = rand.nextInt(GridX-1);
			RandY = rand.nextInt(GridY-1);

			if (counter==1000)
			{
				System.out.println("Map is too crowded for giant whirlpool.");
				break;
			}
			counter++;
		}while(OceanMap.getMap()[RandX][RandY]==true || OceanMap.getMap()[RandX+1][RandY]==true || OceanMap.getMap()[RandX][RandY+1]==true || OceanMap.getMap()[RandX+1][RandY+1]==true || IsShipInWhirlpool(RandX,RandY));		
		
		InitialWhirlpoollocation = new Point(RandX,RandY);
		
		return InitialWhirlpoollocation;
	}

	
	@Override
	public void setWhirlpoollocation(Point NewLocatoion)
	{
	}

	@Override
	public ImageView UploadImage(String path, int scale) {
		return null;
	}
	
	public boolean IsShipInWhirlpool(int X, int Y)
	{
		if ((OceanExplorer.ship.getShipLocation().x == X && OceanExplorer.ship.getShipLocation().y == Y ) || (OceanExplorer.ship.getShipLocation().x == X+1 && OceanExplorer.ship.getShipLocation().y == Y ) || (OceanExplorer.ship.getShipLocation().x == X && OceanExplorer.ship.getShipLocation().y == Y+1 ) || (OceanExplorer.ship.getShipLocation().x == X+1 && OceanExplorer.ship.getShipLocation().y == Y+1 ))
			return true;
		
		return false;
	}
}
