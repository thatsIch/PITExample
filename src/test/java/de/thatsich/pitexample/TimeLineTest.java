package de.thatsich.pitexample;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public final class TimeLineTest
{
	private TimeLine timeline;

	@Before
	public void setUp()
	{
		timeline = new TimeLine();
	}

	@Test
	public void validateInitialFetchCount()
	{
		assertEquals( TimeLine.DEFAULT_FETCH_COUNT, this.timeline.getFetchCount() );
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