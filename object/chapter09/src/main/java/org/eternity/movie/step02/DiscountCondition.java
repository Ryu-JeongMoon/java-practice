package org.eternity.movie.step02;

@FunctionalInterface
public interface DiscountCondition {

	boolean isSatisfiedBy(Screening screening);
}
