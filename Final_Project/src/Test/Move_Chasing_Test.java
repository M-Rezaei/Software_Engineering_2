package Test;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.*;
import Christopher_Columbus_Game.Move_Chasing;


public class Move_Chasing_Test
{
	// Assume ship is located at the (5,5) 

	@Test
	public void CheckLocationTest1()
	{
		Point Testing= new Point(5,3);
		Point Answer = new Point(5,4);
		//Testing = null;
		assertTrue(Move_Chasing.CHECKED_Move(Testing).equals(Answer), "<<< Wrong path has chosen >>>");
	}
	
	@Test
	public void CheckLocationTest2()
	{
		Point Testing= new Point(9,5);
		Point Answer = new Point(8,5);
		assertTrue(Move_Chasing.CHECKED_Move(Testing).equals(Answer), "<<< Wrong path has chosen >>>");
	}
	
	@Test
	public void CheckLocationTest3()
	{
		Point Testing= new Point(5,3);
		Point Answer = new Point(5,4);
		assertTrue(Move_Chasing.CHECKED_Move(Testing).equals(Answer), "<<< Wrong path has chosen >>>");
	}
	
	@Test
	public void CheckLocationTest4()
	{
		Point Testing= new Point(3,3);
		Point Answer = new Point(3,4);
		assertTrue(Move_Chasing.CHECKED_Move(Testing).equals(Answer), "<<< Wrong path has chosen >>>");
	}
	
	@Test
	public void CheckLocationTest5()
	{
		Point Testing= new Point(12,7);
		Point Answer = new Point(11,7);
		assertTrue(Move_Chasing.CHECKED_Move(Testing).equals(Answer), "<<< Wrong path has chosen >>>");
	}
	
	@Test
	public void CheckLocationTest6()
	{
		Point Testing= new Point(0,0);
		Point Answer = new Point(0,1);
		assertTrue(Move_Chasing.CHECKED_Move(Testing).equals(Answer), "<<< Wrong path has chosen >>>");
	}	
}
