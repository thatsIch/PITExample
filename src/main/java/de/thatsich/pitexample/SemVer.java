package de.thatsich.pitexample;


import java.util.Optional;


public final class SemVer
{
	private final int major;
	private final int minor;
	private final int patch;
	private final Optional<Label> maybeLabel;
	private final Optional<BuildMeta> maybeMeta;

	private SemVer( int major, int minor, int patch, Optional<Label> maybeLabel, Optional<BuildMeta> maybeMeta )
	{
		this.major = major;
		this.minor = minor;
		this.patch = patch;
		this.maybeLabel = maybeLabel;
		this.maybeMeta = maybeMeta;
	}

	public static SemVerBuilder builder()
	{
		return new SemVerBuilder();
	}

	public int major()
	{
		return major;
	}

	public int minor()
	{
		return minor;
	}

	public int patch()
	{
		return patch;
	}

	public Optional<Label> maybeLabel()
	{
		return maybeLabel;
	}

	public Optional<BuildMeta> maybeMeta()
	{
		return maybeMeta;
	}

	@Override
	public int hashCode()
	{
		int result = major;
		result = 31 * result + minor;
		result = 31 * result + patch;
		result = 31 * result + maybeLabel.hashCode();
		result = 31 * result + maybeMeta.hashCode();
		return result;
	}

	@Override
	public boolean equals( Object o )
	{
		if( this == o )
		{
			return true;
		}
		if( o == null || getClass() != o.getClass() )
		{
			return false;
		}

		final SemVer semVer = (SemVer) o;

		if( major != semVer.major )
		{
			return false;
		}
		if( minor != semVer.minor )
		{
			return false;
		}
		if( patch != semVer.patch )
		{
			return false;
		}
		if( !maybeLabel.equals( semVer.maybeLabel ) )
		{
			return false;
		}
		return maybeMeta.equals( semVer.maybeMeta );
	}

	@Override
	public String toString()
	{
		final String main = this.major + "." + this.minor + "." + this.patch;
		final String withLabel = main + ( this.maybeLabel.isPresent() ? "-" + this.maybeLabel.get() : "" );
		final String withMeta = withLabel + ( this.maybeMeta.isPresent() ? "+" + this.maybeMeta.get() : "" );

		return withMeta;
	}


	public static final class SemVerBuilder
	{
		private static final Preconditions PRECONDITIONS = new Preconditions();

		private int major;
		private int minor;
		private int patch;
		private Label label;
		private BuildMeta meta;

		private SemVerBuilder()
		{

		}

		public SemVerBuilder major( final int major )
		{
			this.major = major;
			PRECONDITIONS.requireCondition( major >= 0 );

			return this;
		}

		public SemVerBuilder minor( final int minor )
		{
			this.minor = minor;
			PRECONDITIONS.requireCondition( minor >= 0 );

			return this;
		}

		public SemVerBuilder patch( final int patch )
		{
			this.patch = patch;
			PRECONDITIONS.requireCondition( patch >= 0 );

			return this;
		}

		public SemVerBuilder label( final Label label )
		{
			this.label = PRECONDITIONS.requireNotNull( label );

			return this;
		}

		public SemVerBuilder meta( final BuildMeta meta )
		{
			this.meta = PRECONDITIONS.requireNotNull( meta );

			return this;
		}

		public SemVer build()
		{
			final Optional<Label> label = Optional.ofNullable( this.label );
			final Optional<BuildMeta> meta = Optional.ofNullable( this.meta );

			return new SemVer( this.major, this.minor, this.patch, label, meta );
		}
	}
}
