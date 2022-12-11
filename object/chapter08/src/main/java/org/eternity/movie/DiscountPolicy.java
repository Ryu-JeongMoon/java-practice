package org.eternity.movie;

import java.util.List;

import org.eternity.money.Money;

public abstract class DiscountPolicy {

	private final List<DiscountCondition> conditions;

	public DiscountPolicy(DiscountCondition... conditions) {
		this.conditions = List.of(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		return conditions.stream()
			.filter(each -> each.isSatisfiedBy(screening))
			.findFirst()
			.map(each -> getDiscountAmount(screening))
			.orElse(Money.ZERO);
	}

	abstract protected Money getDiscountAmount(Screening Screening);
}
