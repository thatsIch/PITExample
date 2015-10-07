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

	@Override
	public String toString()
	{
		final String main = this.major + "." + this.minor + "." + this.patch;
		final String withLabel = main + ( this.maybeLabel.isPresent() ? "" : "-" + this.maybeLabel.get() );
		final String withMeta = withLabel + ( this.maybeMeta.isPresent() ? "" : "+" + this.maybeMeta.get() );

		return withMeta;
	}

	public static SemVerBuilder builder()
	{
		return new SemVerBuilder();
	}

	public static final class SemVerBuilder
	{
		private static final int DEFAULT_MAJOR = 0;
		private static final int DEFAULT_MINOR = 0;
		private static final int DEFAULT_PATCH = 0;
		private static final Label DEFAULT_LABEL = null;
		private static final BuildMeta DEFAULT_META = null;

		private int major = DEFAULT_MAJOR;
		private int minor = DEFAULT_MINOR;
		private int patch = DEFAULT_PATCH;
		private Label label = DEFAULT_LABEL;
		private BuildMeta meta = DEFAULT_META;

		private SemVerBuilder()
		{

		}

		public SemVerBuilder major( final int major )
		{
			this.major = major;
			Preconditions.requireCondition( major >= 0 );

			return this;
		}

		public SemVerBuilder minor( final int minor )
		{
			this.minor = minor;
			Preconditions.requireCondition( minor >= 0 );

			return this;
		}

		public SemVerBuilder patch( final int patch )
		{
			this.patch = patch;
			Preconditions.requireCondition( patch >= 0 );

			return this;
		}

		public SemVerBuilder label( final Label label )
		{
			this.label = Preconditions.requireNotNull( label );

			return this;
		}

		public SemVerBuilder meta( final BuildMeta meta )
		{
			this.meta = Preconditions.requireNotNull( meta );

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
