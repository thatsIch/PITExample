package de.thatsich.pitexample;


public final class Preconditions
{
	public <T> T requireNotNull( T input )
	{
		if( input == null )
		{
			throw new IllegalArgumentException( "input is not allowed to be null" );
		}

		return input;
	}

	public void requireCondition( boolean condition )
	{
		if( !condition )
		{
			throw new IllegalArgumentException( "condition is not met." );
		}
	}
}
