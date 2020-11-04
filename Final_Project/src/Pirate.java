import java.awt.Point;
import java.util.Random;

/******************************************************************************

                    <<< Christopher Columbus Game >>>
                        Software Engineering (513)

            Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

//Pirate Ship Class:
public class Pirate implements Observer {
	
	Point piratGoalLocation;
	Point piratelocation;
	int Gridx;
	int Gridy;
	boolean[][] oceangrid;
	Random rand = new Random();
	int RandX;
	int RandY;
	
	public Pirate(int GridX, int GridY, boolean[][] oceanGrid)
	{
		Gridx=GridX;
		Gridy=GridY;
		oceangrid=oceanGrid;
		
		do
		{
			RandX = rand.nextInt(Gridx);
			RandY = rand.nextInt(Gridy);
		}while(oceangrid[RandX][RandY]==true);
		
		piratelocation = new Point(RandX,RandY); 
	}
	
	@Override
	public void update(Ship ship)
	{
		if(ship instanceof Ship)
		{
			piratGoalLocation = ship.getShipLocation();
			
			int DistanceX = Math.abs(piratelocation.x - piratGoalLocation.x);
			int Distancey = Math.abs(piratelocation.y - piratGoalLocation.y);
			
			
			if(DistanceX>Distancey)
			{
				if(piratelocation.x - piratGoalLocation.x > 0)
				{
					if(0<piratelocation.x && oceangrid[piratelocation.x-1][piratelocation.y]==false)
						this.piratelocation.x--;
				}
				else if (piratelocation.x - piratGoalLocation.x < 0)
				{
					if(piratelocation.x<Gridx-1 && oceangrid[piratelocation.x+1][piratelocation.y]==false)
						this.piratelocation.x++;
				}
			}
			else
			{
				if (piratelocation.y - piratGoalLocation.y > 0)
				{
					if(0<piratelocation.y && oceangrid[piratelocation.x][piratelocation.y-1]==false)
						this.piratelocation.y--;
				}
				else if (piratelocation.y - piratGoalLocation.y < 0)
				{
					if(piratelocation.y<Gridy-1 && oceangrid[piratelocation.x][piratelocation.y+1]==false)
						this.piratelocation.y++;
				}
			}
		}
	}

	
	public Point getPirateLocation()
	{
		return piratelocation;
	}
	
}
