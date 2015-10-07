package de.thatsich.pitexample;


public class BuildMeta
{
	private final String meta;
	private final int version;

	public BuildMeta( final String meta, final int version )
	{
		this.meta = Preconditions.requireNotNull( meta );
		Preconditions.requireCondition( !meta.isEmpty() );

		this.version = version;
		Preconditions.requireCondition( version >= 0 );
	}

	public String getMeta()
	{
		return meta;
	}

	public int getVersion()
	{
		return version;
	}

	@Override
	public String toString()
	{
		return this.meta + "." + this.version;
	}
}
