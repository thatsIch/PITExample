package de.thatsich.pitexample;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TimeLineTest
{
	private TimeLine timeline;

	@Before
	public void setUp()
	{
		timeline = new TimeLine();
	}

	@Test
	public void setFetchCount()
	{
		int expected = 5;
		timeline.setFetchCount( expected );
		int actual = timeline.getFetchCount();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void setFetchCountWithNonPositiveValue()
	{
		timeline.setFetchCount( 0 );
	}
}