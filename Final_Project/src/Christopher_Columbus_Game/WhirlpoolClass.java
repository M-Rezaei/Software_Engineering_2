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

public class WhirlpoolClass implements Whirlpool
{
	Point Whirlpoollocation;
	ImageView WhirlpoolImageView;

	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	
	Random rand = new Random();
	int RandX;
	int RandY;		

	
	@Override
	public void Creator()
	{
		Whirlpoollocation = InitialLocation(); 
		WhirlpoolImageView = UploadImage("Photos\\Whirlpool.png", Scale); 
		
		WhirlpoolImageView.setX(Whirlpoollocation.x * Scale);
		WhirlpoolImageView.setY(Whirlpoollocation.y * Scale);
		
		OceanExplorer.pane.getChildren().add(WhirlpoolImageView);
	}
	
	public ImageView UploadImage(String path, int scale)
	{
		Image WhirlpoolImage = new Image(path,scale,scale,true,true);
		ImageView WhirlpoolImageView = new ImageView(WhirlpoolImage);
		return WhirlpoolImageView; 
	}
	
	public Point InitialLocation()
	{	
		Point InitialWhirlpoollocation;
		do
		{
			RandX = rand.nextInt(GridX);
			RandY = rand.nextInt(GridY);
		}while(OceanMap.getMap()[RandX][RandY]==true || (OceanExplorer.ship.getShipLocation().x == RandX && OceanExplorer.ship.getShipLocation().y == RandY ));
		
		InitialWhirlpoollocation = new Point(RandX,RandY);
		
		return InitialWhirlpoollocation;
		
	}
	
	public void setWhirlpoollocation(Point NewLocatoion)
	{
		Whirlpoollocation = NewLocatoion;
	}
	
	public Point getWhirlpoollocation()
	{
		return Whirlpoollocation;
	}

	public ImageView getWhirlpoolImageView()
	{
		return WhirlpoolImageView;
	}

	@Override
	public boolean IsShipInWhirlpool(int X, int Y) {
		return false;
	}

}
