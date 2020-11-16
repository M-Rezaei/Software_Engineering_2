package Christopher_Columbus_Game;
import java.awt.Point;
import javafx.scene.image.ImageView;

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

public interface Container
{
	public int monsterWinner();
	public Point getMonsterLocation();
	public void setMonsterLocation(int x, int y);
	public ImageView getMonsterMonsterImageView();
	public void setXMonsterImageView(int x);
	public void setYMonsterImageView(int y);
	public void add(Container container);
	public void remove(Container container);
	public Container getChild(int i);
	public Point getMonsterLocationFromTheList(int Winner);
	public ImageView getMonsterImageViewFromTheList(int Winner);
	}
