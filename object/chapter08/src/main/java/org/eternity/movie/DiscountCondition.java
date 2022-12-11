package org.eternity.movie;

@FunctionalInterface
public interface DiscountCondition {

	boolean isSatisfiedBy(Screening screening);
}
