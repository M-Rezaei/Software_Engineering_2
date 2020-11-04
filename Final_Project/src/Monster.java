import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/******************************************************************************

                  <<< Christopher Columbus Game >>>
                      Software Engineering (513)

           Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

// Upload the Ghosts on the Screen:
class MonsterImage
{
	int X;
	int Y;
	ImageView MonsterView;
	Image monsterImage;
	
	MonsterImage(int X, int Y, int scale)
	{
		this.X=X;
		this.Y=Y;
			
		monsterImage = new Image("Photos\\Monster.png",scale,scale,false,true);
		MonsterView  = new ImageView(monsterImage);
		MonsterView.setX(X*scale);
		MonsterView.setY(Y*scale);
	}
	
	ImageView getMonster()
	{
		return MonsterView;
	}
	
}


public class Monster implements Runnable 
{
	Boolean running = true;
	int monsterNumber;
	int Gridx;
	int Gridy;
	int scale;
	boolean[][] oceangrid;
	
	MonsterImage[] monsterImages;
	
	int RandX;
	int RandY;
	Random rand = new Random();

	public Monster (int MonsterNumber, int GridX, int GridY, int Scale, boolean[][] oceanGrid)
	{
		monsterNumber=MonsterNumber;
		Gridx=GridX;
		Gridy=GridY;
		scale=Scale;
		oceangrid=oceanGrid;
		
		monsterImages = new MonsterImage[monsterNumber];

		for (int i=0; i<monsterNumber; i++)
		{
			do
			{
				RandX = rand.nextInt(Gridx);
				RandY = rand.nextInt(Gridy);
			}while(oceangrid[RandX][RandY]==true);

			monsterImages[i] = new MonsterImage(RandX, RandY, scale);	
		}	
	}

	public void addToPane(AnchorPane sceneGraph){
		for(MonsterImage monsterImage: monsterImages)
		{	
			ImageView MonsterView = monsterImage.getMonster();
			sceneGraph.getChildren().add(MonsterView);
		}
	}
	
	
	
	@Override
    public void run()
	{
		while (true)
		{
	    	try
	    	{
				Thread.sleep(2000);
			}
	    	
	    	catch (InterruptedException e)
	    	{
				e.printStackTrace();
			}
	    	
	    	
	    	for(MonsterImage monsterImage: monsterImages)
	    	{ 		
	    		ImageView MonsterView = monsterImage.getMonster();
	    		
	    		// Generate random number: 1=Up , 2=Left , 3=Down , 4=Right.
	    		int min = 1;
	    		int max = 4;
	    		int NextPlace = rand.nextInt((max - min) + 1) + min; //Generate random number inclusively between min and max
	    		
	    		if (NextPlace==1) // Up
	    		{
	    			if(0<(int)MonsterView.getY() && oceangrid[((int)MonsterView.getX())/scale][((int)MonsterView.getY())/scale-1]==false)
	    				MonsterView.setY(MonsterView.getY()-scale);	
	    		}
	    		else if (NextPlace==2) // Left
	    		{
	    			if(0<(int)MonsterView.getX() && oceangrid[((int)MonsterView.getX())/scale-1][((int)MonsterView.getY())/scale]==false)
	    				MonsterView.setX(MonsterView.getX()-scale);	
	    		}
	    		else if (NextPlace==3) // Down
	    		{
	    			if(((int)MonsterView.getY())/scale<Gridy-1 && oceangrid[((int)MonsterView.getX())/scale][((int)MonsterView.getY())/scale+1]==false)
	    				MonsterView.setY(MonsterView.getY()+scale);	
	    		}
	    		else if  (NextPlace==4)// Right
	    		{
	    			if(((int)MonsterView.getX())/scale<Gridx-1 && oceangrid[((int)MonsterView.getX())/scale+1][((int)MonsterView.getY())/scale]==false)
	    				MonsterView.setX(MonsterView.getX()+scale);	
	    		}
	    		
	    		
	    			
	    	}
		}
	}

}


