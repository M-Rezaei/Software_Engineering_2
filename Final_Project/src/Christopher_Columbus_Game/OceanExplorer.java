package Christopher_Columbus_Game;
import java.awt.Point;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;


/******************************************************************************

                     <<< Christopher Columbus Game >>>
                         Software Engineering (513)

           Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  
      
*******************************************************************************/

public class OceanExplorer extends Application
{
	
	/**********************************************************************************************/
	public static final int Scale                        = 50;   // Size   (Size of each cell of the Ocean) 
	public static final int GridX                        = 13;   // Width  (Number of Cell in Width)
	public static final int GridY                        = 13;   // Height (Number of Cell in Height)
	public static final int Island                       = 25;   // Number of Islands
	public static final int PirateIslandNumber           = 2;    // Number of Pirate Islands
	public static final int PirateRevengeNumber          = 1;    // Number of Revenge Pirate Ships	
	public static final int PirateAdventureGalleyNumber  = 2;    // Number of Adventure Galley Pirate Ships	

	/**********************************************************************************************/
	Scene scene;
	public static AnchorPane pane;
	int WinerMonster = -1;                         // Monster that catch the ship 
	static Ship ship;                              // Object of the Ship Class (Determines location of the ship)
	PirateAdventureGalley[] pirateAdventureGalley; // Array of Adventure Galley Pirate Ships
	PirateRevenge[] pirateRevenge;                 // Array of Revenge Pirate Ships
	PirateIsland[] pirateIsland;                   // Array of PirateIsland Object
	TreasuresIsland treasureIsland;                // Object of the TreasureIsland
	Container monster1;                            // Object of the Monster1
	Container monster2;						   	   // Object of the Monster2
	Container monster3;						       // Object of the Monster3
	Container monsterTeam1;                        // Object of the MonsterTeam1
	Container monsterTeam2;						   // Object of the MonsterTeam2
	Whirlpool whirlpool;                           // Object of the whirlpool
	Whirlpool crazyWhirlpool;                      // Object of the Decorated Whirlpool
	boolean Finish = false;                        // Checks when the games is over  
	Media mediaBackground;
	MediaPlayer playerBackground;
	Media mediaWin;
	MediaPlayer playerWin;
	Media mediaLose;
	MediaPlayer playerLose;
	Media mediaMove;
	MediaPlayer playerMove;
	boolean GameStart = false;
	ImageView Start1ImageView;
	ImageView Start2ImageView;
	

	/**********************************************************************************************/
	//Upload Related Image For Ending The Game:
	public void EndGame(int EndNumber, int Winner)
	{
		Image GameOverImage = new Image("Photos\\GameOver.png",(GridX*Scale)/2,(GridY*Scale)/2,true,true);
		ImageView GameOverImageview = new ImageView(GameOverImage);
		GameOverImageview.setX((GridX*Scale)/4);
		GameOverImageview.setY((GridY*Scale)/4);

		if( EndNumber == 1 )  // Pirate Ship Won the Game.
		{
			Image PirateflagImage = new Image("Photos\\Flag.png",Scale,Scale,true,true);
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirateAdventureGalley[Winner].getPirateLocation().x * Scale);
			PirateflagImageview.setY(pirateAdventureGalley[Winner].getPirateLocation().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}
		else if( EndNumber == 2 )  // Pirate Ship Won the Game.
		{
			Image PirateflagImage = new Image("Photos\\Flag.png",Scale,Scale,true,true);
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirateRevenge[Winner].getPirateLocation().x * Scale);
			PirateflagImageview.setY(pirateRevenge[Winner].getPirateLocation().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}
		else if ( EndNumber == 3 )  // Pirate Island Won the Game.
		{
			Image PirateflagImage = new Image("Photos\\Flag.png",Scale,Scale,true,true);
			ImageView PirateflagImageview = new ImageView(PirateflagImage);
			PirateflagImageview.setX(pirateIsland[Winner].getpirateIslandLocaction().x * Scale);
			PirateflagImageview.setY(pirateIsland[Winner].getpirateIslandLocaction().y * Scale);
			pane.getChildren().add(PirateflagImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}

		else if ( EndNumber == 4 )  // Ship Won the Game.
		{
			Image WinImage = new Image("Photos\\Win.png",(GridX*Scale)/2,(GridY*Scale)/2,true,true);
			ImageView WinflagImageview = new ImageView(WinImage);
			WinflagImageview.setX((GridX*Scale)/4);
			WinflagImageview.setY((GridY*Scale)/4);
			pane.getChildren().add(WinflagImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerWin.play();
		}
		else if ( EndNumber == 5 )  // Monster Won the Game.
		{
			Image DrownedByMonsterImage = new Image("Photos\\DrownedByMonster.png",Scale,Scale,true,true);
			ImageView DrownedShipImageview = new ImageView(DrownedByMonsterImage);
			DrownedShipImageview.setX(monsterTeam1.getMonsterLocationFromTheList(Winner).x * Scale);
			DrownedShipImageview.setY(monsterTeam1.getMonsterLocationFromTheList(Winner).y * Scale);
			pane.getChildren().remove(ship.shipImageView);
			pane.getChildren().remove(monsterTeam1.getMonsterImageViewFromTheList(Winner));
			pane.getChildren().add(DrownedShipImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}	
		else if ( EndNumber == 6 )  // Monster Won the Game.
		{
			Image DrownedByMonsterImage = new Image("Photos\\DrownedByMonster.png",Scale,Scale,true,true);
			ImageView DrownedShipImageview = new ImageView(DrownedByMonsterImage);
			DrownedShipImageview.setX(monsterTeam2.getMonsterLocationFromTheList(Winner).x * Scale);
			DrownedShipImageview.setY(monsterTeam2.getMonsterLocationFromTheList(Winner).y * Scale);
			pane.getChildren().remove(ship.shipImageView);
			pane.getChildren().remove(monsterTeam2.getMonsterImageViewFromTheList(Winner));
			pane.getChildren().add(DrownedShipImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}
		
		else if ( EndNumber == 7 )  // Whirlpool Won the Game.
		{
			Image DrownedByWhirlpoolImage = new Image("Photos\\DrownedByWhirlpool.png",Scale,Scale,true,true);
			ImageView DrownedByWhirlpoolImageview = new ImageView(DrownedByWhirlpoolImage);
			DrownedByWhirlpoolImageview.setX(whirlpool.getWhirlpoollocation().x * Scale);
			DrownedByWhirlpoolImageview.setY(whirlpool.getWhirlpoollocation().y * Scale);
			pane.getChildren().remove(ship.shipImageView);
			pane.getChildren().remove(whirlpool.getWhirlpoolImageView());
			pane.getChildren().add(DrownedByWhirlpoolImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}
		
		else if ( EndNumber == 8 )  // Whirlpool Won the Game.
		{
			Image DrownedByWhirlpoolCrazyImage = new Image("Photos\\DrownedByWhirlpoolCrazy.png",Scale*2,Scale*2,true,true);
			ImageView DrownedByWhirlpoolCrazyImageview = new ImageView(DrownedByWhirlpoolCrazyImage);
			DrownedByWhirlpoolCrazyImageview.setX(crazyWhirlpool.getWhirlpoollocation().x * Scale);
			DrownedByWhirlpoolCrazyImageview.setY(crazyWhirlpool.getWhirlpoollocation().y * Scale);
			pane.getChildren().remove(ship.shipImageView);
			pane.getChildren().remove(crazyWhirlpool.getWhirlpoolImageView());
			pane.getChildren().add(DrownedByWhirlpoolCrazyImageview);
			pane.getChildren().add(GameOverImageview);
			Finish = true;
			playerBackground.setVolume(0.02);
			playerLose.play();
		}
	}
	
	/**********************************************************************************************/
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
					if(GameStart==false)
					{
						pane.getChildren().remove(Start1ImageView);
						pane.getChildren().remove(Start2ImageView);
						GameStart=true;
					}
					
					playerMove.stop();
					switch(ke.getCode())
					{
						case RIGHT:
							ship.goEast();
							playerMove.play();
							break;
						case LEFT:
							ship.goWest();
							playerMove.play();
							break;
						case UP:
							ship.goNorth();
							playerMove.play();
							break;
						case DOWN:
							ship.goSouth();
							playerMove.play();
							break;
						default:
							break;
					}
					
					// Updates New Locations:
					ship.shipImageView.setX(ship.getShipLocation().x*Scale);
					ship.shipImageView.setY(ship.getShipLocation().y*Scale);
					
					for (int i=0; i<PirateAdventureGalleyNumber; i++)
					{
						pirateAdventureGalley[i].PirateShipImageView.setX(pirateAdventureGalley[i].getPirateLocation().x*Scale);
						pirateAdventureGalley[i].PirateShipImageView.setY(pirateAdventureGalley[i].getPirateLocation().y*Scale);
					}
					
					for (int i=0; i<PirateRevengeNumber; i++)
					{
						pirateRevenge[i].PirateShipImageView.setX(pirateRevenge[i].getPirateLocation().x*Scale);
						pirateRevenge[i].PirateShipImageView.setY(pirateRevenge[i].getPirateLocation().y*Scale);
					}
					
					// Checks when the games is over: 
					
					for (int i=0; i<PirateAdventureGalleyNumber; i++)
						if(Finish == false && ship.getShipLocation().x == pirateAdventureGalley[i].getPirateLocation().x && ship.getShipLocation().y == pirateAdventureGalley[i].getPirateLocation().y)
							EndGame(1, i);

					for (int i=0; i<PirateRevengeNumber; i++)
						if(Finish == false && ship.getShipLocation().x == pirateRevenge[i].getPirateLocation().x && ship.getShipLocation().y == pirateRevenge[i].getPirateLocation().y)
							EndGame(2, i);

					for (int i=0; i<PirateIslandNumber; i++)			
					{
						if(Finish == false && pirateIsland[i].getpirateIslandLocaction().x == ship.getShipLocation().x)
							if((pirateIsland[i].getpirateIslandLocaction().y)-1 == ship.getShipLocation().y || (pirateIsland[i].getpirateIslandLocaction().y)+1 == ship.getShipLocation().y)
								EndGame(3, i);
					
						if(Finish == false && pirateIsland[i].getpirateIslandLocaction().y == ship.getShipLocation().y)
							if((pirateIsland[i].getpirateIslandLocaction().x)-1 == ship.getShipLocation().x || (pirateIsland[i].getpirateIslandLocaction().x)+1 == ship.getShipLocation().x)
									EndGame(3, i);
					}
					
					
					if (Finish == false)
					{
					WinerMonster = monsterTeam1.monsterWinner();
					if(WinerMonster != -1)
						EndGame(5, WinerMonster);
					}
					
					if (Finish == false)
					{
					WinerMonster = monsterTeam2.monsterWinner();
					if(WinerMonster != -1)
						EndGame(6, WinerMonster);
					}
					
					if(Finish == false && treasureIsland.getTreasureIslandLocaction().x == ship.getShipLocation().x)
						if((treasureIsland.getTreasureIslandLocaction().y)-1 == ship.getShipLocation().y || (treasureIsland.getTreasureIslandLocaction().y)+1 == ship.getShipLocation().y)
							EndGame(4, -1);
					if(Finish == false && treasureIsland.getTreasureIslandLocaction().y == ship.getShipLocation().y)
						if((treasureIsland.getTreasureIslandLocaction().x)-1 == ship.getShipLocation().x || (treasureIsland.getTreasureIslandLocaction().x)+1 == ship.getShipLocation().x)
							EndGame(4, -1);
					
					if(Finish == false && whirlpool.getWhirlpoollocation().x == ship.getShipLocation().x && whirlpool.getWhirlpoollocation().y == ship.getShipLocation().y)
						EndGame(7, -1);
					
					if(Finish == false && (crazyWhirlpool.IsShipInWhirlpool(crazyWhirlpool.getWhirlpoollocation().x, crazyWhirlpool.getWhirlpoollocation().y)))
						{
							EndGame(8, -1);
						}

				}
			}
		});
	}
	
	
	/**********************************************************************************************/
	// The Stage:
	@Override
	public void start(Stage OceanStage) throws Exception
	{

		pane = new AnchorPane(); 
		
		OceanMap.getInstance();		

		pirateIsland  =new PirateIsland[PirateIslandNumber];
		for (int i=0; i<PirateIslandNumber; i++)
			pirateIsland[i] = new PirateIsland();
		
		treasureIsland =new TreasuresIsland();
		
		ship = new Ship();
		
		whirlpool      = new WhirlpoolClass();
		whirlpool.Creator();
		
		crazyWhirlpool = new WhirlpoolDecoratorCrazy(new WhirlpoolClass());
		crazyWhirlpool.Creator();
		
		pirateAdventureGalley = new PirateAdventureGalley[PirateAdventureGalleyNumber];
		for (int i=0; i<PirateAdventureGalleyNumber; i++)
			pirateAdventureGalley[i] = new PirateAdventureGalley();
		
		pirateRevenge = new PirateRevenge[PirateRevengeNumber];
		for (int i=0; i<PirateRevengeNumber; i++)
			pirateRevenge[i] = new PirateRevenge();

		
		monster1      = new Monster(2);      // The boundaries are: (1= All of the ocean) (2=Upper half of the ocean) (3=Lower half of the ocean)
		monster2      = new Monster(2);      // The boundaries are: (1= All of the ocean) (2=Upper half of the ocean) (3=Lower half of the ocean)	
		monsterTeam1  = new MonsterTeam(2);  // The boundaries are: (1= All of the ocean) (2=Upper half of the ocean) (3=Lower half of the ocean)	
		monsterTeam1.add(monster1);
		monsterTeam1.add(monster2);
		
		monster3      = new Monster(3);      // The boundaries are: (1= All of the ocean) (2=Upper half of the ocean) (3=Lower half of the ocean)	
		monsterTeam2  = new MonsterTeam(3);  // The boundaries are: (1= All of the ocean) (2=Upper half of the ocean) (3=Lower half of the ocean)
		monsterTeam2.add(monster3);			
		
		Button Restart = new Button("    Restart    ");
		Restart.setTranslateX(((GridY*Scale)/2)-(Scale/2));
		Restart.setTranslateY(0);
		pane.getChildren().add(Restart);
		Restart.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override
            public void handle(ActionEvent event) {
            	try {
            		Finish=false;
            		GameStart=false;
            		OceanMap.clear();
            		start(OceanStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
            	}	            
        });
		
		
        mediaBackground = new Media(new File("src\\Voices\\Background.mp3").toURI().toString());
        playerBackground = new MediaPlayer(mediaBackground); 
        playerBackground.setVolume(0.12);
        MediaView playerView = new MediaView(playerBackground);
        pane.getChildren().add(playerView);
        
        mediaWin = new Media(new File("src\\Voices\\Win.wav").toURI().toString());
        playerWin = new MediaPlayer(mediaWin); 
        playerWin.setVolume(0.1);
        
        mediaLose = new Media(new File("src\\Voices\\Lose.wav").toURI().toString());
        playerLose = new MediaPlayer(mediaLose); 
        playerLose.setVolume(0.2);
        
        mediaMove = new Media(new File("src\\Voices\\Move.wav").toURI().toString());
        playerMove = new MediaPlayer(mediaMove); 
        playerMove.setVolume(0.12);
        
		scene = new Scene(pane, (GridX*Scale), (GridY*Scale));
		OceanStage.setTitle("Christopher Columbus Game  (^_^)");
		OceanStage.setScene(scene);
		
		Image Start1Image = new Image("Photos\\Start.png",Scale-(Scale/10),Scale-(Scale/10),true,true);
		Start1ImageView = new ImageView(Start1Image);
		Start1ImageView.setX(treasureIsland.treasureIslandLocaction.x * Scale);
		Start1ImageView.setY(treasureIsland.treasureIslandLocaction.y * Scale);
		OceanExplorer.pane.getChildren().add(Start1ImageView);
		Image Start2Image = new Image("Photos\\Start.png",Scale,Scale,true,true);
		Start2ImageView = new ImageView(Start2Image);
		Start2ImageView.setX(ship.currentLocation.x * Scale);
		Start2ImageView.setY(ship.currentLocation.y * Scale);
		OceanExplorer.pane.getChildren().add(Start2ImageView);
		
		OceanStage.show();
		
		playerBackground.setAutoPlay(true);	
		
		startSailing();	
	}

	
	public boolean IsItInsideTheMap(Point Location)
	{
		int X = Location.x;
		int Y = Location.y;
		
		if (0 <= X && X < GridX && 0 <= Y && Y < GridY)
			return true;
		
		return false;
	}
	
	public static boolean CHECKED_IsItInsideTheMap(Point Location)
	{
		if (Location == null) 
			  throw new IllegalArgumentException("<<< It is Null. >>>");
		
		int X = Location.x;
		int Y = Location.y;
		
		if (0 <= X && X < GridX && 0 <= Y && Y < GridY)
			return true;
		
		return false;
	}
	
	
	/**********************************************************************************************/
	// Main Method: 
	public static void main(String[] args)
	{
		launch(args);
	}

}
