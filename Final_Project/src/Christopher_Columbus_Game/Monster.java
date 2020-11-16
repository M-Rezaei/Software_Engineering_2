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

public class Monster implements Container  
{
	Boolean running = true;
	
	int GridX = OceanExplorer.GridX;
	int GridY = OceanExplorer.GridY;
	int Scale = OceanExplorer.Scale;
	
	Image monsterImage;
	ImageView MonsterImageView;
	Point monsterlocation;

	int RandX;
	int RandY;
	Random rand = new Random();

	public Monster(int boundary)
	{		
		do
		{
			RandX = rand.nextInt(GridX);
			
			if(boundary==1)
				RandY = rand.nextInt(GridY);
			else if(boundary==2)
				RandY = rand.nextInt(GridY/2);
			else if (boundary==3)
				RandY = rand.nextInt((GridY - (GridY/2))) + (GridY/2);
				
		}while(OceanMap.getMap()[RandX][RandY]==true || (OceanExplorer.ship.getShipLocation().x == RandX && OceanExplorer.ship.getShipLocation().y == RandY ) );
		
		monsterlocation = new Point(RandX,RandY);
		
		monsterImage = new Image("Photos\\Monster.png",Scale,Scale,false,true);
		MonsterImageView  = new ImageView(monsterImage);
		MonsterImageView.setX(monsterlocation.x * Scale);
		MonsterImageView.setY(monsterlocation.y * Scale);
		OceanExplorer.pane.getChildren().add(MonsterImageView);
	}
	
	public Point getMonsterLocation()
	{
		return monsterlocation;
	}
	
	public ImageView getMonsterMonsterImageView()
	{
		return MonsterImageView;
	}

	public void setMonsterLocation(int x, int y)
	{
		monsterlocation.x=x;
		monsterlocation.y=y;
	}
	
	public void setXMonsterImageView(int x)
	{
		MonsterImageView.setX(x * Scale);	
	}

	public void setYMonsterImageView(int y)
	{
		MonsterImageView.setY(y * Scale);	

	}


	
	
	@Override
	public int monsterWinner() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(Container container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Container container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Container getChild(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getMonsterLocationFromTheList(int Winner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageView getMonsterImageViewFromTheList(int Winner) {
		// TODO Auto-generated method stub
		return null;
	}

}


