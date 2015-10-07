package de.thatsich.pitexample;


public class Label
{
	private final String label;
	private final int version;

	public Label( final String label, final int version )
	{
		this.label = Preconditions.requireNotNull( label );
		Preconditions.requireCondition( !label.isEmpty() );

		this.version = version;
		Preconditions.requireCondition( version >= 0 );
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
