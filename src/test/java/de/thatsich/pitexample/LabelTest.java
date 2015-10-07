package de.thatsich.pitexample;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public final class LabelTest
{
	private Label label;

	@Before
	public void setUp()
	{
		label = new Label("pre", 0);
	}

	@Test
	public void testGetLabel() throws Exception
	{
		final String expected = "pre";
		final String actual = this.label.getLabel();

		assertEquals( expected, actual );
	}

	@Test
	public void testGetVersion() throws Exception
	{
		final int expected = 0;
		final int actual = this.label.getVersion();

		assertEquals( expected, actual );
	}

	@Test
	public void testToString()
	{
		final String expected = "pre.0";
		final String actual = this.label.toString();

		assertEquals( expected, actual );
	}
}