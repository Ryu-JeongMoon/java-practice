package org.eternity.movie.step02;

import java.time.Duration;

import org.eternity.money.Money;

public record Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {

	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
}

