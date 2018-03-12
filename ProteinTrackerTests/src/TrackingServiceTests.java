import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.simpleprogrammer.proteintracker.HistoryItem;
import com.simpleprogrammer.proteintracker.InvalidGoalException;
import com.simpleprogrammer.proteintracker.TrackingService;


public class TrackingServiceTests {

	private TrackingService service;
	
	@BeforeClass
	public static void before()
	{
		System.out.println("Before Class");
	}
	
	
	@AfterClass
	public static void after()
	{
		System.out.println("AFter Class");
	}
	
	//@Before will be called before every @Test
	@Before
	public void setUp()
	{
		System.out.println("Before");
		service = new TrackingService();
	}
	
	//@After: For UnitTests @After is NOT used as often as @Before
	@After
	public void tearDown()
	{
		//Integration-Test: Rollback Database
		System.out.println("After");
	}
	
	@Test
	@Category({GoodTestsCategory.class,	BadCategory.class})
	public void NewTrackingServiceTotalIsZero()
	{
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Ignore
	public void WhenAddingProteinTotalIncreasesByThatAmount()
	{
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenRemovingProteinTotalRemainsZero()
	{
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Test(expected = InvalidGoalException.class)
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException
	{
		service.setGoal(-5);
	}
	
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenRemovingProteinAfterAddingProteinRemainsZero()
	{
		service.addProtein(5);
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Ignore
	@Test
	public void WhenGoalIsMet()
	{
		service.setGoal(5);
		service.addProtein(5);
		assertEquals(true, service.isGoalMet());
	}	
	
	@Ignore
	@Test
	public void WhenGoalIsNotMet()
	{
		service.setGoal(5);
		service.addProtein(4);
		assertEquals(false, service.isGoalMet());
	}
	
	@Test(timeout = 200)
	public void BadTest()
	{
		for(int i =0; i < 10000000; i++)
			service.addProtein(1);
	}

	@Test
	@Category(GoodTestsCategory.class)
	public void WhenGetHistoryIsNotNull()
	{
//		private List<HistoryItem> history = new ArrayList<HistoryItem>();
		System.out.println("WhenGetHistoryIsNotNull");
		assertNotNull(service.getHistory());

	}
	
	@Test
	public void WhenGetHistoryArrayEquals()
	{
		service.addProtein(1);
		assertArrayEquals(new Object[]{new Integer(1)}, service.getHistory().toArray());
	}


	
}