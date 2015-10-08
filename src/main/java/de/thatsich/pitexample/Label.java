package de.thatsich.pitexample;


public class Label
{
	private static final Preconditions PRECONDITIONS = new Preconditions();

	private final String label;
	private final int version;

	public Label( final String label, final int version )
	{
		this.label = PRECONDITIONS.requireNotNull( label );
		PRECONDITIONS.requireCondition( !label.isEmpty() );

		this.version = version;
		PRECONDITIONS.requireCondition( version >= 0 );
	}

	public String getLabel()
	{
		return this.label;
	}

	public int getVersion()
	{
		return this.version;
	}

	@Override
	public String toString()
	{
		return this.label + "." + this.version;
	}
}
