package Christopher_Columbus_Game;
// Subject is the Columbus Ship

/******************************************************************************

					<<< Christopher Columbus Game >>>
						Software Engineering (513)

			Mosab Rezaei (z1905541)  -  Hamed Barzamini (z1907279)  

*******************************************************************************/

public interface Subject
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
