package com.simpleprogrammer.proteintracker.tests;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.core.StringContains.containsString;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

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
		//assertEquals(10, service.getTotal());
		//assertThat(service.getTotal(), is(10));
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenRemovingProteinTotalRemainsZero()
	{
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test //(expected = InvalidGoalException.class)
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException
	{
		thrown.expect(InvalidGoalException.class);
		//thrown.expectMessage("Goal was less then zero!");
		thrown.expectMessage(containsString("Goal"));
		service.setGoal(-5);
	}
	
	
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenRemovingProteinAfterAddingProteinRemainsZero()
	{
//		for(int i =0; i < 10000000; i++)
//			service.addProtein(1);
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
	
	@Rule
	public Timeout timeout = new Timeout(20, TimeUnit.MILLISECONDS);
	
	@Ignore
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
	
	@Ignore
	@Test
	public void WhenGetHistoryArrayEquals()
	{
		service.addProtein(1);
		assertArrayEquals(new Object[]{new Integer(1)}, service.getHistory().toArray());
	}


	
}