package de.thatsich.pitexample;


import java.util.Objects;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


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
	public void testBuilderWithMajor() throws Exception
	{
		final String expected = "1.0.0";

		final String actual = SemVer.builder().major( 1 ).build().toString();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testBuilderWithNegMajor() throws Exception
	{
		SemVer.builder().major( -1 );
	}

	@Test
	public void testBuilderWithMinor() throws Exception
	{
		final String expected = "0.1.0";

		final String actual = SemVer.builder().minor( 1 ).build().toString();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testBuilderWithNegMinor() throws Exception
	{
		SemVer.builder().minor( -1 );
	}

	@Test
	public void testBuilderWithPatch() throws Exception
	{
		final String expected = "0.0.1";

		final String actual = SemVer.builder().patch( 1 ).build().toString();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testBuilderWithNegPatch() throws Exception
	{
		SemVer.builder().patch( -1 );
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

	@Test
	public void testEquals()
	{
		assertEquals( this.semVer, this.semVer );
	}

	@Test
	public void testUnequalNull()
	{
		assertNotEquals( this.semVer, null );
	}

	@Test
	public void testUnequalOther()
	{
		assertNotEquals( this.semVer, new Label( "test", 0 ) );
	}

	@Test
	public void testUnequalOtherObject()
	{
		assertNotEquals( this.semVer, new Object() );
	}

	@Test
	public void testUnequalPositiveMajor()
	{
		final int expected = 1;
		final SemVer build = SemVer.builder().major( expected ).build();
		final int actual = build.major();

		assertEquals( expected, actual );
	}

	@Test
	public void testUnequalZeroMajor()
	{
		final int expected = 0;
		final SemVer build = SemVer.builder().major( expected ).build();
		final int actual = build.major();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testUnequalNegativeMajor()
	{
		final int expected = -1;
		final SemVer build = SemVer.builder().major( expected ).build();
		final int actual = build.major();

		assertEquals( expected, actual );
	}

	// test minor

	@Test
	public void testUnequalPositiveMinor()
	{
		final int expected = 1;
		final SemVer build = SemVer.builder().minor( expected ).build();
		final int actual = build.minor();

		assertEquals( expected, actual );
	}

	@Test
	public void testUnequalZeroMinor()
	{
		final int expected = 0;
		final SemVer build = SemVer.builder().minor( expected ).build();
		final int actual = build.minor();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testUnequalNegativeMinor()
	{
		final int expected = -1;
		final SemVer build = SemVer.builder().minor( expected ).build();
		final int actual = build.minor();

		assertEquals( expected, actual );
	}

	// test patch

	@Test
	public void testUnequalPositivePatch()
	{
		final int expected = 1;
		final SemVer build = SemVer.builder().patch( expected ).build();
		final int actual = build.patch();

		assertEquals( expected, actual );
	}

	@Test
	public void testUnequalZeroPatch()
	{
		final int expected = 0;
		final SemVer build = SemVer.builder().patch( expected ).build();
		final int actual = build.patch();

		assertEquals( expected, actual );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testUnequalNegativePatch()
	{
		final int expected = -1;
		final SemVer build = SemVer.builder().patch( expected ).build();
		final int actual = build.patch();

		assertEquals( expected, actual );
	}

	// test label
	@Test
	public void testEmptyLabel()
	{
		assertEquals( Optional.empty(), SemVer.builder().build().maybeLabel() );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testIllegalLabel()
	{
		SemVer.builder().label( null );
	}

	// test meta
	@Test
	public void testEmptyMeta()
	{
		assertEquals( Optional.empty(), SemVer.builder().build().maybeMeta() );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testIllegalMeta()
	{
		SemVer.builder().meta( null );
	}

	// test equals
	@Test
	public void testEqualIdentity()
	{
		assertTrue( Objects.equals( this.semVer, this.semVer ) );
	}

	@Test
	public void testUnequalMajor()
	{
		assertNotEquals( this.semVer, SemVer.builder().major( 1 ).build() );
	}

	@Test
	public void testUnequalMinor()
	{
		assertNotEquals( this.semVer, SemVer.builder().minor( 1 ).build() );
	}

	@Test
	public void testUnequalPatch()
	{
		assertNotEquals( this.semVer, SemVer.builder().patch( 1 ).build() );
	}

	@Test
	public void testUnequalLabel()
	{
		final Label label = new Label( "label", 0 );

		assertNotEquals( this.semVer, SemVer.builder().label( label ).build() );
	}

	@Test
	public void testUnequalMeta()
	{
		final BuildMeta meta = new BuildMeta( "label", 0 );

		assertNotEquals( this.semVer, SemVer.builder().meta( meta ).build() );
	}

	@Test
	public void testEqualHash()
	{
		final SemVer build = SemVer.builder().build();

		assertEquals( this.semVer.hashCode(), build.hashCode() );
	}

	@Test
	public void testEqualsSymmetric()
	{
		final SemVer reference = SemVer.builder().build();

		assertTrue( this.semVer.equals( reference ) );
		assertTrue( reference.equals( this.semVer ) );
	}

	@Test
	public void testObjectInequality()
	{
		final SemVer unequal = SemVer.builder().build();

		assertTrue( this.semVer != unequal );
	}

	// testing hash
	@Test
	public void testHashSymmetric()
	{
		final int expected = this.semVer.hashCode();
		final int actual = SemVer.builder().build().hashCode();

		assertEquals( expected, actual );
	}

	@Test
	public void testHashValue()
	{
		assertEquals( 0, this.semVer.hashCode() );
	}

	@Test
	public void testHashConcreteValue()
	{
		final Label label = new Label( "label", 0 );
		final BuildMeta meta = new BuildMeta( "meta", 0 );

		assertEquals( ( 1026 * 31 + label.hashCode() ) * 31 + meta.hashCode(), SemVer.builder().major( 1 ).minor( 2 ).patch( 3 ).label( label ).meta( meta ).build().hashCode() );
	}
}