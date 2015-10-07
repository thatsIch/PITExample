package de.thatsich.pitexample;


public final class Preconditions
{
	private Preconditions() {

	}

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
