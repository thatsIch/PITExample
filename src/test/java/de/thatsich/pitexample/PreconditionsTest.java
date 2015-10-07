package de.thatsich.pitexample;


import org.junit.Test;


/**
 * Created by thatsIch on 08.10.2015.
 */
public class PreconditionsTest
{

	@Test(expected = IllegalArgumentException.class)
	public void testRequireNotNull() throws Exception
	{
		Preconditions.requireNotNull( null );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRequireCondition() throws Exception
	{
		Preconditions.requireCondition( false );
	}
}