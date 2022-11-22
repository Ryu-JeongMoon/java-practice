package org.eternity.movie.step02;

import java.time.Duration;
import java.util.List;

import org.eternity.money.Money;

public class Movie {

	private final List<PeriodCondition> periodConditions;
	private final List<SequenceCondition> sequenceConditions;
	private final String title;
	private final Duration runningTime;
	private final Money fee;
	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Movie(
		String title, Duration runningTime, Money fee,
		List<PeriodCondition> periodConditions, List<SequenceCondition> sequenceConditions
	) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.periodConditions = periodConditions;
		this.sequenceConditions = sequenceConditions;
	}

	public Money calculateMovieFee(Screening screening) {
		if (isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}

		return fee;
	}

	private boolean isDiscountable(Screening screening) {
		return checkPeriodConditions(screening)
			|| checkSequenceConditions(screening);
	}

	private boolean checkPeriodConditions(Screening screening) {
		return periodConditions.stream()
			.anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	private boolean checkSequenceConditions(Screening screening) {
		return sequenceConditions.stream()
			.anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	private Money calculateDiscountAmount() {
		return switch (movieType) {
			case AMOUNT_DISCOUNT -> calculateAmountDiscountAmount();
			case PERCENT_DISCOUNT -> calculatePercentDiscountAmount();
			case NONE_DISCOUNT -> calculateNoneDiscountAmount();
		};

	}

	private Money calculateAmountDiscountAmount() {
		return discountAmount;
	}

	private Money calculatePercentDiscountAmount() {
		return fee.times(discountPercent);
	}

	private Money calculateNoneDiscountAmount() {
		return Money.ZERO;
	}
}
