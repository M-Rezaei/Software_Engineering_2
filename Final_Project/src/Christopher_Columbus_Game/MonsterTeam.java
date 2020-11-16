package Christopher_Columbus_Game;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.scene.image.ImageView;

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)
	
			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

public class MonsterTeam implements Container, Observer 
{
	public List<Container> monsters = new ArrayList<Container>();
	
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	int boundary;
	int upperLimit;
	int lowerLimit;
	int RandX;
	int RandY;
	int lenghtOftheList = 0;
	Random rand = new Random();
	int tempX;
	int tempY;

	
	public MonsterTeam(int boundary)
	{
		OceanExplorer.ship.registerObserver(this);
		this.boundary = boundary;
		
		if(boundary==1)
		{
			lowerLimit = 0;
			upperLimit = GridY;
		}
		else if(boundary==2)
		{
			lowerLimit = 0;
			upperLimit = GridY/2;
		}		
		else if (boundary==3)
		{
			lowerLimit = GridY/2;
			upperLimit = GridY;
		}				
	}
	
	public void add(Container container)
	{
		monsters.add(container);
		lenghtOftheList++;
	}
	
	public void remove(Container container)
	{
		monsters.remove(container);
		lenghtOftheList--;
	}
	
	public Container getChild(int i)
	{
		return monsters.get(i);
	}


	@Override
	public void update(Ship ship)
	{
		if(ship instanceof Ship)
		{
	    	for (int i=0; i<lenghtOftheList; i++)
			{ 			    		
	    		tempX = getChild(i).getMonsterLocation().x;
	    		tempY = getChild(i).getMonsterLocation().y;
	    		// Generate random number: 1=Up , 2=Left , 3=Down , 4=Right.
	    		int min = 1;
	    		int max = 4;
	    		int NextPlace = rand.nextInt((max - min) + 1) + min; //Generate random number inclusively between min and max
	    		
	    		if (NextPlace==1) // Up
	    		{
	    			if(lowerLimit<tempY && OceanMap.getMap()[tempX][tempY-1]==false)
    				{
	    				tempY--;
	    				getChild(i).setMonsterLocation(tempX, tempY);
	    				getChild(i).setYMonsterImageView(tempY);
    				}
	    		}
	    		else if (NextPlace==2) // Left
	    		{
	    			if(0<tempX && OceanMap.getMap()[tempX-1][tempY]==false)
    				{
    					tempX--;
    					getChild(i).setMonsterLocation(tempX, tempY);
    					getChild(i).setXMonsterImageView(tempX);	
    				}
	    		}
	    		else if (NextPlace==3) // Down
	    		{
	    			if(tempY<upperLimit-1 && OceanMap.getMap()[tempX][tempY+1]==false)
    				{
    					tempY++;
    					getChild(i).setMonsterLocation(tempX, tempY);
    					getChild(i).setYMonsterImageView(tempY);	
    				}
	    		}
	    		else if  (NextPlace==4)// Right
	    		{
	    			if(tempX<GridX-1 && OceanMap.getMap()[tempX+1][tempY]==false)
    				{
    					tempX++;
    					getChild(i).setMonsterLocation(tempX, tempY);
    					getChild(i).setXMonsterImageView(tempX);	
    				}
	    		}
	    	}
		}
	}


	
	public int monsterWinner()
	{
    	Iterator<Container> containerIterator = monsters.iterator();
    	int i = 0;
    	while(containerIterator.hasNext())
    	{ 		
    		Container container = containerIterator.next();
    		if(OceanExplorer.ship.getShipLocation().x == container.getMonsterLocation().x && OceanExplorer.ship.getShipLocation().y == container.getMonsterLocation().y)
    			return i;
    		i++;    			
    	}
		return -1;	
	}
	
	
	public int CheckedmonsterWinner()
	{
		if (monsters.isEmpty() == true)
			  throw new IllegalArgumentException("There is not any monster at this team.");

    	Iterator<Container> containerIterator = monsters.iterator();
    	int i = 0;
    	while(containerIterator.hasNext())
    	{ 		
    		Container container = containerIterator.next();
    		if(OceanExplorer.ship.getShipLocation().x == container.getMonsterLocation().x && OceanExplorer.ship.getShipLocation().y == container.getMonsterLocation().y)
    			return i;
    		i++;    			
    	}
		return -1;	
	}
	
	public Point getMonsterLocationFromTheList(int Winner)
	{
		return monsters.get(Winner).getMonsterLocation();
	}
	
	public ImageView getMonsterImageViewFromTheList(int Winner)
	{
		return monsters.get(Winner).getMonsterMonsterImageView();
	}
	
	
	@Override
	public Point getMonsterLocation()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMonsterLocation(int x, int y) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setXMonsterImageView(int x) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setYMonsterImageView(int y) {
		// TODO Auto-generated method stub	
	}

	@Override
	public ImageView getMonsterMonsterImageView() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
