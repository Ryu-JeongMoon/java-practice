package org.eternity.billing.step07;

import java.time.Duration;

import org.eternity.money.Money;

public class NightlyDiscountPhone extends Phone {

	private static final int LATE_NIGHT_HOUR = 22;

	private final Money nightlyAmount;
	private final Money regularAmount;
	private final Duration seconds;

	public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		if (call.from().getHour() >= LATE_NIGHT_HOUR) {
			return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
		} else {
			return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
		}
	}
}
