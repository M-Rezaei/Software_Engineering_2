package Christopher_Columbus_Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/


public abstract class WhirlpoolDecorator implements Whirlpool
{
	Image WhirlpoolCrazyImage;	
	ImageView WhirlpoolCrazyImageView;
	protected Whirlpool decorateWhirlpool;

	public WhirlpoolDecorator(Whirlpool decorateWhirlpool)
	{
		this.decorateWhirlpool = decorateWhirlpool;
	}
	
	public void Creator()
	{
		decorateWhirlpool.Creator();
	}
}
