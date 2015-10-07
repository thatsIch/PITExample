package de.thatsich.pitexample;


/**
 * Created by thatsIch on 07.10.2015.
 */
public final class Preconditions
{
	public static <T> T requireNotNull( T input )
	{
		if( input == null )
		{
			throw new IllegalArgumentException( "input is not allowed to be null" );
		}

		return input;
	}

	public static void requireCondition( boolean condition )
	{
		if( !condition )
		{
			throw new IllegalArgumentException( "condition is not met." );
		}
	}
}
