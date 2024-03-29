package org.eternity.movie.step02.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step02.DiscountPolicy;
import org.eternity.movie.step02.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
