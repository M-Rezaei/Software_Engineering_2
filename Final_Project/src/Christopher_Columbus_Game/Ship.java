package Christopher_Columbus_Game;
import java.util.List;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Point;
import java.util.LinkedList;

/******************************************************************************

                      <<< Christopher Columbus Game >>>
                          Software Engineering (513)

            Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/


// The Ship Class: Points and Controls the current Location of the Ship 
public class Ship implements Subject
{
	
	List<Observer> observers = new LinkedList<Observer>();

	Point currentLocation;
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	
	ImageView shipImageView;
	
	Random rand = new Random();
	int RandX;
	int RandY;
	
	public Ship()
	{
		Image shipImage = new Image("Photos\\ship.png",Scale,Scale,true,true);
		shipImageView = new ImageView(shipImage);
		
		do
		{
			RandX = rand.nextInt(GridX);
			RandY = rand.nextInt(GridY);
		}while(OceanMap.getMap()[RandX][RandY]==true);
		
		currentLocation = new Point(RandX,RandY);	
		
		shipImageView.setX(currentLocation.x * Scale);
		shipImageView.setY(currentLocation.y * Scale);
		
		OceanExplorer.pane.getChildren().add(shipImageView);
	}

	public void goEast()
	{
		if(currentLocation.x<GridX-1 && OceanMap.getMap()[currentLocation.x+1][currentLocation.y]==false)
		{
			currentLocation.x++;
			notifyObservers();
		}
	}
	
	public void goWest()
	{
		if(0<currentLocation.x && OceanMap.getMap()[currentLocation.x-1][currentLocation.y]==false)
		{
			currentLocation.x--;
			notifyObservers();
		}		
	}

	public void goNorth()
	{
		if(0<currentLocation.y && OceanMap.getMap()[currentLocation.x][currentLocation.y-1]==false)
		{
			currentLocation.y--;
			notifyObservers();
		}		
	}

	public void goSouth()
	{
		if(currentLocation.y<GridY-1 && OceanMap.getMap()[currentLocation.x][currentLocation.y+1]==false)
		{
			currentLocation.y++;
			notifyObservers();
		}		
	}

	
	public Point getShipLocation()
	{
		return currentLocation;
	}
	
	
	@Override
	public void registerObserver(Observer o)
	{
		observers.add(o);	
	}

	@Override
	public void removeObserver(Observer o)
	{
		if(observers.contains(o))
			observers.remove(o);
	}

	@Override
	public void notifyObservers()
	{
		for (Observer AllObserver: observers)
			AllObserver.update(this);
		
	}

	public void setShipLocation(int x, int y)
	{
		currentLocation.x = x;
		currentLocation.y = y;
		this.shipImageView.setX(x*Scale);
		this.shipImageView.setY(y*Scale);
	}
	
}
