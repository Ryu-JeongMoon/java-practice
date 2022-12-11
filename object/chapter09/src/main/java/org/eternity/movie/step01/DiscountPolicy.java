package org.eternity.movie.step01;

import java.util.List;

import org.eternity.money.Money;

public abstract class DiscountPolicy {

	private final List<DiscountCondition> conditions;

	public DiscountPolicy(DiscountCondition... conditions) {
		this.conditions = List.of(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		return conditions.stream()
			.filter(condition -> condition.isSatisfiedBy(screening))
			.findFirst()
			.map(condition -> getDiscountAmount(screening))
			.orElse(screening.getMovieFee());
	}

	abstract protected Money getDiscountAmount(Screening Screening);
}
