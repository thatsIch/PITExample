package de.thatsich.pitexample;


import org.junit.Before;
import org.junit.Test;


/**
 * Created by thatsIch on 08.10.2015.
 */
public class PreconditionsTest
{
	private Preconditions preconditions;

	@Before
	public void setUp()
	{
		this.preconditions = new Preconditions();
	}

	@Test( expected = IllegalArgumentException.class )
	public void testRequireNotNull() throws Exception
	{
		this.preconditions.requireNotNull( null );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testRequireCondition() throws Exception
	{
		this.preconditions.requireCondition( false );
	}
}