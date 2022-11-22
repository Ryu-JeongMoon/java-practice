package org.eternity.movie.step04;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.eternity.money.Money;

import lombok.Getter;

@Getter
public abstract class Movie {

	private final String title;
	private final Duration runningTime;
	private final Money fee;
	private final List<DiscountCondition> discountConditions;

	public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountConditions = Arrays.asList(discountConditions);
	}

	public Money calculateMovieFee(Screening screening) {
		if (isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}

		return fee;
	}

	private boolean isDiscountable(Screening screening) {
		return discountConditions.stream()
			.anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	protected Money getFee() {
		return fee;
	}

	abstract protected Money calculateDiscountAmount();
}
