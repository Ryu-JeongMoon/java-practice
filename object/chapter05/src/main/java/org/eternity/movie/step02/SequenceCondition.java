package org.eternity.movie.step02;

public record SequenceCondition(int sequence) {

	public boolean isSatisfiedBy(Screening screening) {
		return sequence == screening.sequence();
	}
}
