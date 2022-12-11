package org.eternity.movie.step02.pricing;

import org.eternity.movie.step02.DiscountCondition;
import org.eternity.movie.step02.Screening;

public record SequenceCondition(int sequence) implements DiscountCondition {

	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
