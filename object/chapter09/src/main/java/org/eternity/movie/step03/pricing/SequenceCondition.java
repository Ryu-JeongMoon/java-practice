package org.eternity.movie.step03.pricing;

import org.eternity.movie.step03.DiscountCondition;
import org.eternity.movie.step03.Screening;

public record SequenceCondition(int sequence) implements DiscountCondition {

	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
