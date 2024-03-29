package org.eternity.movie.step04;

import java.time.Duration;

import org.eternity.money.Money;

public class PercentDiscountMovie extends Movie {

	private final double percent;

	public PercentDiscountMovie(
		String title, Duration runningTime, Money fee, double percent,
		DiscountCondition... discountConditions
	) {
		super(title, runningTime, fee, discountConditions);
		this.percent = percent;
	}

	@Override
	protected Money calculateDiscountAmount() {
		return getFee().times(percent);
	}
}
