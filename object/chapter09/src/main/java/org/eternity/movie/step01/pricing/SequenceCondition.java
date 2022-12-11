package org.eternity.movie.step01.pricing;

import org.eternity.movie.step01.DiscountCondition;
import org.eternity.movie.step01.Screening;

public record SequenceCondition(int sequence) implements DiscountCondition {

	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
