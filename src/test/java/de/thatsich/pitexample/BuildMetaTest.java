package de.thatsich.pitexample;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public final class BuildMetaTest
{
	private BuildMeta meta;

	@Before
	public void setUp()
	{
		meta = new BuildMeta( "build", 0 );
	}

	@Test
	public void testGetMeta() throws Exception
	{
		final String expected = "build";
		final String actual = this.meta.getMeta();

		assertEquals( expected, actual );
	}

	@Test
	public void testGetVersion() throws Exception
	{
		final int expected = 0;
		final int actual = this.meta.getVersion();

		assertEquals( expected, actual );
	}

	@Test
	public void testToString()
	{
		final String expected = "build.0";
		final String actual = this.meta.toString();

		assertEquals( expected, actual );
	}
}