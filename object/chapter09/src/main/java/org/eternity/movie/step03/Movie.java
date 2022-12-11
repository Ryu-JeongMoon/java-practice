package org.eternity.movie.step03;

import java.time.Duration;

import org.eternity.money.Money;
import org.eternity.movie.step03.locator.ServiceLocator;

public record Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {

	public Movie(String title, Duration runningTime, Money fee) {
		this(title, runningTime, fee, ServiceLocator.discountPolicy());
	}

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}

	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
}

