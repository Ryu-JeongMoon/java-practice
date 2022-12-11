package org.eternity.movie.step01;

@FunctionalInterface
public interface DiscountCondition {

	boolean isSatisfiedBy(Screening screening);
}
