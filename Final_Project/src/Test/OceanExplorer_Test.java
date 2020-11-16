package Test;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.*;
import Christopher_Columbus_Game.OceanExplorer;


public class OceanExplorer_Test
{

	@Test
	public void CheckLocationTest1()
	{
		Point Testing= new Point(2,2);
		Testing = null;
		assertTrue(OceanExplorer.CHECKED_IsItInsideTheMap(Testing) == true, "<<< It is out of the Map >>>");
	}
	
	@Test
	public void CheckLocationTest2()
	{
		Point Testing= new Point(7,14);
		assertTrue(OceanExplorer.CHECKED_IsItInsideTheMap(Testing) == true, "<<< It is out of the Map >>>");
	}
	
	
	@Test
	public void CheckLocationTest3()
	{
		Point Testing= new Point(6,8);
		assertTrue(OceanExplorer.CHECKED_IsItInsideTheMap(Testing) == true, "<<< It is out of the Map >>>");
	}

	@Test
	public void CheckLocationTest4()
	{
		Point Testing= new Point(0,0);
		assertTrue(OceanExplorer.CHECKED_IsItInsideTheMap(Testing) == true, "<<< It is out of the Map >>>");
	}
	
	@Test
	public void CheckLocationTest5()
	{
		Point Testing= new Point(-5,2);
		assertTrue(OceanExplorer.CHECKED_IsItInsideTheMap(Testing) == true, "<<< It is out of the Map >>>");
	}
	
	@Test
	public void CheckLocationTest6()
	{
		Point Testing= new Point(18,20);
		assertTrue(OceanExplorer.CHECKED_IsItInsideTheMap(Testing) == true, "<<< It is out of the Map >>>");
	}
	
}
