package org.eternity.movie.step03;

@FunctionalInterface
public interface DiscountCondition {

	boolean isSatisfiedBy(Screening screening);
}
