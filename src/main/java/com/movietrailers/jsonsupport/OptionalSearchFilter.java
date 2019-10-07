package com.movietrailers.jsonsupport;

public final class OptionalSearchFilter {
	private String releaseYear;
	private int genreIds[];
	private String rateGreaterOrEqual;
	private String rateLessOrEqual;
	
	/*public OptionalSearchFilter(String releaseYear, String[] genres, String rateGreaterOrEqual,
			String rateLessOrEqual) {
		super();
		this.releaseYear = releaseYear;
		this.genres = genres;
		this.rateGreaterOrEqual = rateGreaterOrEqual;
		this.rateLessOrEqual = rateLessOrEqual;
	}*/
	
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int[] getGenreIds() {
		return genreIds;
	}
	public void setGenreIds(int[] genreIds) {
		this.genreIds = genreIds;
	}
	public String getRateGreaterOrEqual() {
		return rateGreaterOrEqual;
	}
	public void setRateGreaterOrEqual(String rateGreaterOrEqual) {
		this.rateGreaterOrEqual = rateGreaterOrEqual;
	}
	public String getRateLessOrEqual() {
		return rateLessOrEqual;
	}
	public void setRateLessOrEqual(String rateLessOrEqual) {
		this.rateLessOrEqual = rateLessOrEqual;
	}
}