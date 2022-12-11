package org.eternity.movie.pricing;

import java.util.List;

import org.eternity.money.Money;
import org.eternity.movie.DiscountPolicy;
import org.eternity.movie.Screening;

public class OverlappedDiscountPolicy extends DiscountPolicy {

	private final List<DiscountPolicy> discountPolicies;

	public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
		this.discountPolicies = List.of(discountPolicies);
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountPolicies.stream()
			.map(each -> each.calculateDiscountAmount(screening))
			.reduce(Money.ZERO, Money::plus);
	}
}
