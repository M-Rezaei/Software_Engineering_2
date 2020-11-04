import java.util.List;
import java.util.Random;
import java.awt.Point;
import java.util.LinkedList;

/******************************************************************************

                      <<< Christopher Columbus Game >>>
                          Software Engineering (513)

            Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/


// The Ship Class: Points and Controls the current Location of the Ship 
public class Ship implements Subject {
	
	List<Observer> observers = new LinkedList<Observer>();

	Point currentLocation;
	int Gridx;
	int Gridy;
	boolean[][] oceangrid;
	Random rand = new Random();
	int RandX;
	int RandY;
	
	Ship(int GridX, int GridY, boolean[][] oceanGrid)
	{
		Gridx=GridX;
		Gridy=GridY;
		oceangrid=oceanGrid;
		
		do
		{
			RandX = rand.nextInt(Gridx);
			RandY = rand.nextInt(Gridy);
		}while(oceangrid[RandX][RandY]==true);
		
		currentLocation = new Point(RandX,RandY);	
	}

	public void goEast()
	{
		if(currentLocation.x<Gridx-1 && oceangrid[currentLocation.x+1][currentLocation.y]==false)
		{
			currentLocation.x++;
			notifyObservers();
		}
	}
	
	public void goWest()
	{
		if(0<currentLocation.x && oceangrid[currentLocation.x-1][currentLocation.y]==false)
		{
			currentLocation.x--;
			notifyObservers();
		}		
	}

	public void goNorth()
	{
		if(0<currentLocation.y && oceangrid[currentLocation.x][currentLocation.y-1]==false)
		{
			currentLocation.y--;
			notifyObservers();
		}		
	}

	public void goSouth()
	{
		if(currentLocation.y<Gridy-1 && oceangrid[currentLocation.x][currentLocation.y+1]==false)
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
		for (Observer piratesObserver: observers)
			piratesObserver.update(this);
		
	}

}
