import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/******************************************************************************

                    <<< Christopher Columbus Game >>>
                       Software Engineering (513)

          Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  
      
*******************************************************************************/

public class OceanExplorer extends Application
{

	final int Scale = 60;          // Controls Size of the Map an Ship on the Screen
	final int GridX = 11;          // Width
	final int GridY = 11;          // Height
	final int Island = 15;         // Number of Island
	final int MonsterNumber = 2;   // Number of Monster
	int WinerMonster  = -1;        // Witch monster must change 
		
	Scene scene;                     // Creating Scene:
	AnchorPane pane;
	ImageView shipImageView;          
	ImageView PirateShipImageView1;
	ImageView PirateShipImageView2;
	ImageView PirateIslandView1;
	ImageView PirateIslandView2;
	ImageView TreasureIslandView;
	
	OceanMap oceanMap;             //Object of OceanMap Class
	boolean[][] oceanGrid;         //Determines that where are the islands
	
	Ship ship;                      //Object of the Ship Class (Determines location of the ship)
	Pirate pirate1;		            //First  Object of the Pirate Class
	Pirate pirate2;		            //Second Object of the Pirate Class
	PirateIsland pirateIsland1;     //First  Object of the PirateIsland Class
	PirateIsland pirateIsland2;     //second  Object of the PirateIsland Class
	TreasureIsland2 treasureIsland; //object of the TreasureIsland
	Monster monster;                //object of the monster
	Thread monsterThread;           //thread for monster objects
	
	boolean Finish = false;  // Checks when the games is over.

	
	
	// Upload the Ocean Image on the Screen: 
	public void drawMap()
	{	
		Image OceanImage = new Image("Photos\\Ocean.jpg",Scale*GridX,Scale*GridY,true,true);
		ImageView OceanView = new ImageView(OceanImage);
		OceanView.setX(0);
		OceanView.setY(0);
		pane.getChildren().add(OceanView);			
	}
	
	// Uploads Islands on the Screen:
	public void drawIsland()
	{
		for(int x = 0; x < GridX; x++)
		{
			for(int y = 0; y < GridY; y++)
			{
				if (oceanGrid[x][y]==true)
				{
					Image IslandImage = new Image("Photos\\Island.png",Scale,Scale,true,true);
					ImageView IslandView = new ImageView(IslandImage);
					IslandView.setX(x * Scale);
					IslandView.setY(y * Scale);
					pane.getChildren().add(IslandView);	
				}
			}
		}
	}
	
	// Upload Pirate Islands on the screen:
	public void drawPirateIsland()
	{
		Image PirateIslandImage1 = new Image("Photos\\PirateIsland.png",Scale,Scale,true,true);
		PirateIslandView1 = new ImageView(PirateIslandImage1);
		PirateIslandView1.setX(pirateIsland1.getpirateIslandLocaction().x * Scale);
		PirateIslandView1.setY(pirateIsland1.getpirateIslandLocaction().y * Scale);
		pane.getChildren().add(PirateIslandView1);
		
		Image PirateIslandImage2 = new Image("Photos\\PirateIsland.png",Scale,Scale,true,true);
		PirateIslandView2 = new ImageView(PirateIslandImage2);
		PirateIslandView2.setX(pirateIsland2.getpirateIslandLocaction().x * Scale);
		PirateIslandView2.setY(pirateIsland2.getpirateIslandLocaction().y * Scale);
		pane.getChildren().add(PirateIslandView2);
		
	}
	
	// Upload Pirate Islands on the screen:
	public void drawTreasureIsland()
	{
		Image TreasureIslandImage = new Image("Photos\\TreasureIsland.png",Scale,Scale,true,true);
		TreasureIslandView = new ImageView(TreasureIslandImage);
		TreasureIslandView.setX(treasureIsland.getTreasureIslandLocaction().x * Scale);
		TreasureIslandView.setY(treasureIsland.getTreasureIslandLocaction().y * Scale);
		pane.getChildren().add(TreasureIslandView);
		
	}
	
	// Upload the Ship on the Screen:
	public void loadShipImage()
	{
		Image shipImage = new Image("Photos\\ship.png",Scale,Scale,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * Scale);
		shipImageView.setY(ship.getShipLocation().y * Scale);
		pane.getChildren().add(shipImageView);
	}
	
	// Upload the Pirate Ship on the Screen:
	public void loadPirateImage()
	{
		Image PirateShipImage = new Image("Photos\\pirateship.png",Scale,Scale,true,true);
		PirateShipImageView1 = new ImageView(PirateShipImage);
		PirateShipImageView1.setX(pirate1.getPirateLocation().x * Scale);
		PirateShipImageView1.setY(pirate1.getPirateLocation().y * Scale);
		pane.getChildren().add(PirateShipImageView1);
		
		Image PirateShipImage2 = new Image("Photos\\pirateship.png",Scale,Scale,true,true);
		PirateShipImageView2 = new ImageView(PirateShipImage2);
		PirateShipImageView2.setX(pirate2.getPirateLocation().x * Scale);
		PirateShipImageView2.setY(pirate2.getPirateLocation().y * Scale);
		pane.getChildren().add(PirateShipImageView2);
	}
	
	
	
	//Upload Pirate Flag Victory on the Screen:
	
	public void EndGame(int EndNumber)
	{
		Image PirateflagImage = new Image("Photos\\Flag.png",Scale,Scale,true,true);
		Image WinImage = new Image("Photos\\Win.png",(GridX*Scale)/2,(GridY*Scale)/2,true,true);
		Image DrownedShipImage = new Image("Photos\\DrownedShip.png",Scale,Scale,true,true);
		
		if(EndNumber == 1 )                               // Pirate Ship 1 Won the Game.
		{
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirate1.getPirateLocation().x * Scale);
			PirateflagImageview.setY(pirate1.getPirateLocation().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			Finish = true;
		}
		else if (EndNumber == 2 )                          // Pirate Ship 2 Won the Game.
		{
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirate2.getPirateLocation().x * Scale);
			PirateflagImageview.setY(pirate2.getPirateLocation().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			Finish = true;			
		}
		else if (EndNumber == 3 )                         // Pirate Island 1 Won the Game.
		{
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirateIsland1.getpirateIslandLocaction().x * Scale);
			PirateflagImageview.setY(pirateIsland1.getpirateIslandLocaction().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			Finish = true;			
		}
		else if (EndNumber == 4 )                         // Pirate Island 2 Won the Game.
		{
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirateIsland2.getpirateIslandLocaction().x * Scale);
			PirateflagImageview.setY(pirateIsland2.getpirateIslandLocaction().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			Finish = true;
		}
		else if (EndNumber == 5 )                         // Pirate Island 2 Won the Game.
		{
			ImageView WinflagImageview = new ImageView(WinImage);
			WinflagImageview.setX((GridX*Scale)/4);
			WinflagImageview.setY((GridY*Scale)/4);
			pane.getChildren().add(WinflagImageview);
			Finish = true;
		}
		else if (EndNumber == 6 )                         // Pirate Island 2 Won the Game.
		{
			ImageView DrownedShipImageview = new ImageView(DrownedShipImage);
			DrownedShipImageview.setX(monster.monsterImages[WinerMonster].MonsterView.getX());
			DrownedShipImageview.setY(monster.monsterImages[WinerMonster].MonsterView.getY());
			pane.getChildren().remove(shipImageView);
			pane.getChildren().remove(monster.monsterImages[WinerMonster].MonsterView);
			pane.getChildren().add(DrownedShipImageview);
			Finish = true;
		}		
	}
	
	// the Event Handler for controlling Ship by Arrow Keys:
	private void startSailing()
	{
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent ke)
			{
				if(!Finish)
				{
					switch(ke.getCode())
					{
						case RIGHT:
							ship.goEast();
							break;
						case LEFT:
							ship.goWest();
							break;
						case UP:
							ship.goNorth();
							break;
						case DOWN:
							ship.goSouth();
							break;
						default:
							break;
						
					}
					
					// Updates New Locations:
					shipImageView.setX(ship.getShipLocation().x*Scale);
					shipImageView.setY(ship.getShipLocation().y*Scale);
					PirateShipImageView1.setX(pirate1.getPirateLocation().x*Scale);
					PirateShipImageView1.setY(pirate1.getPirateLocation().y*Scale);
					PirateShipImageView2.setX(pirate2.getPirateLocation().x*Scale);
					PirateShipImageView2.setY(pirate2.getPirateLocation().y*Scale);
					
					
					// Checks when the games is over: 
					if(Finish == false && ship.getShipLocation().x == pirate1.getPirateLocation().x && ship.getShipLocation().y == pirate1.getPirateLocation().y)
						EndGame(1);
					
					if(Finish == false && ship.getShipLocation().x == pirate2.getPirateLocation().x && ship.getShipLocation().y == pirate2.getPirateLocation().y)
						EndGame(2);
					
					if(Finish == false && pirateIsland1.getpirateIslandLocaction().x == ship.getShipLocation().x)
						if((pirateIsland1.getpirateIslandLocaction().y)-1 == ship.getShipLocation().y || (pirateIsland1.getpirateIslandLocaction().y)+1 == ship.getShipLocation().y)
							EndGame(3);
					
					if(Finish == false && pirateIsland1.getpirateIslandLocaction().y == ship.getShipLocation().y)
						if((pirateIsland1.getpirateIslandLocaction().x)-1 == ship.getShipLocation().x || (pirateIsland1.getpirateIslandLocaction().x)+1 == ship.getShipLocation().x)
							EndGame(3);
					
					if(Finish == false && pirateIsland2.getpirateIslandLocaction().x == ship.getShipLocation().x)
						if((pirateIsland2.getpirateIslandLocaction().y)-1 == ship.getShipLocation().y || (pirateIsland2.getpirateIslandLocaction().y)+1 == ship.getShipLocation().y)
							EndGame(4);
					
					if(Finish == false && pirateIsland2.getpirateIslandLocaction().y == ship.getShipLocation().y)
						if((pirateIsland2.getpirateIslandLocaction().x)-1 == ship.getShipLocation().x || (pirateIsland2.getpirateIslandLocaction().x)+1 == ship.getShipLocation().x)
							EndGame(4);
					
					if(Finish == false && treasureIsland.getTreasureIslandLocaction().x == ship.getShipLocation().x)
						if((treasureIsland.getTreasureIslandLocaction().y)-1 == ship.getShipLocation().y || (treasureIsland.getTreasureIslandLocaction().y)+1 == ship.getShipLocation().y)
							EndGame(5);
					
					if(Finish == false && treasureIsland.getTreasureIslandLocaction().y == ship.getShipLocation().y)
						if((treasureIsland.getTreasureIslandLocaction().x)-1 == ship.getShipLocation().x || (treasureIsland.getTreasureIslandLocaction().x)+1 == ship.getShipLocation().x)
							EndGame(5);
					
					for (int i=0; i<MonsterNumber; i++)
						if(Finish == false && ship.getShipLocation().x == (monster.monsterImages[i].MonsterView.getX())/Scale && ship.getShipLocation().y == (monster.monsterImages[i].MonsterView.getY())/Scale)
							{
								WinerMonster = i;
								EndGame(6);
							}
					
				}
			}
		});
	}
	
	
	// The Stage:
	@Override
	public void start(Stage OceanStage) throws Exception
	{

		pane = new AnchorPane(); 

		oceanMap = new OceanMap(GridX, GridY, Island);
		oceanGrid = oceanMap.getMap();
		

		pirateIsland1  =new PirateIsland(GridX, GridY, oceanGrid);
		pirateIsland2  =new PirateIsland(GridX, GridY, oceanGrid);
		treasureIsland =new TreasureIsland2(GridX, GridY, oceanGrid);
		ship = new Ship(GridX,GridY,oceanGrid);
		pirate1 = new Pirate(GridX,GridY,oceanGrid);
		pirate2 = new Pirate(GridX,GridY,oceanGrid);
		monster = new Monster(MonsterNumber, GridX, GridY, Scale, oceanGrid);
		//monster.addToPane(pane);
		
		
		drawMap();
		drawIsland();
		drawPirateIsland();
		drawTreasureIsland();
		loadShipImage();
		loadPirateImage();

		ship.registerObserver(pirate1);
		ship.registerObserver(pirate2);	
		
		//pane.getChildren().addAll(monster.monsterImages[0].MonsterView);
		//pane.getChildren().addAll(monster.monsterImages[1].MonsterView);
		
		monster.addToPane(pane);
		
		scene = new Scene(pane, (GridX*Scale), (GridY*Scale));
		OceanStage.setTitle("Christopher Columbus Game  (^_^)");
		OceanStage.setScene(scene);
		
		OceanStage.show();
		
		monsterThread = new Thread(monster);
		monsterThread.start();
		
		startSailing();
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void stop()
	{
		monsterThread.stop();
	}
	
	// Main Method: 
	public static void main(String[] args)
	{
		launch(args);
	}

}
