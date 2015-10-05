package de.thatsich.pitexample;


public class TimeLine
{
	static final int DEFAULT_FETCH_COUNT = 10;
	private int fetchCount;

	public TimeLine()
	{
		fetchCount = DEFAULT_FETCH_COUNT;
	}

	public void setFetchCount( int fetchCount )
	{
		if( fetchCount <= 0 )
		{
			String msg = "Argument 'fetchCount' must be a positive value.";
			throw new IllegalArgumentException( msg );
		}
		this.fetchCount = fetchCount;
	}

	public int getFetchCount()
	{
		return fetchCount;
	}
}
