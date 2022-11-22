package org.eternity.movie.step03;

public record SequenceCondition(int sequence) implements DiscountCondition {

	public boolean isSatisfiedBy(Screening screening) {
		return sequence == screening.sequence();
	}
}
