package Christopher_Columbus_Game;
import java.awt.Point;
import javafx.scene.image.ImageView;


/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/


public interface Whirlpool
{
	public void Creator();
	public ImageView UploadImage(String path, int scale);
	public Point InitialLocation();
	public Point getWhirlpoollocation();
	public ImageView getWhirlpoolImageView();
	public void setWhirlpoollocation(Point NewLocatoion);
	public boolean IsShipInWhirlpool(int X, int Y);
}
