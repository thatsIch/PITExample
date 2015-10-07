package de.thatsich.pitexample;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SemVerTest
{
	private SemVer semVer;

	@Before
	public void setUp()
	{
		this.semVer = SemVer.builder().build();
	}

	@Test
	public void testToString() throws Exception
	{
		final String expected = "0.0.0";
		final String actual = this.semVer.toString();

		assertEquals( expected, actual );
	}

	@Test
	public void testBuilder() throws Exception
	{
		final SemVer expected = this.semVer;
		final SemVer actual = SemVer.builder().build();

		assertEquals( expected, actual );
	}

	@Test
	public void testBuilderWithLabel() throws Exception
	{
		final String expected = "0.0.0-label.0";

		final Label label = new Label( "label", 0 );
		final String actual = SemVer.builder().label( label ).build().toString();

		assertEquals( expected, actual );
	}

	@Test
	public void testBuilderWithMeta() throws Exception
	{
		final String expected = "0.0.0+meta.0";

		final BuildMeta meta = new BuildMeta( "meta", 0 );
		final String actual = SemVer.builder().meta( meta ).build().toString();

		assertEquals( expected, actual );
	}

	@Test
	public void testBuilderWithLabelAndMeta() throws Exception
	{
		final String expected = "0.0.0-label.0+meta.0";

		final Label label = new Label( "label", 0 );
		final BuildMeta meta = new BuildMeta( "meta", 0 );
		final String actual = SemVer.builder().label( label ).meta( meta ).build().toString();

		assertEquals( expected, actual );
	}
}