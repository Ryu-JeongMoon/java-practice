package org.eternity.billing.step01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.eternity.money.Money;

import lombok.Getter;

@Getter
public class NightlyDiscountPhone {

	private static final int LATE_NIGHT_HOUR = 22;

	private final Money nightlyAmount;
	private final Money regularAmount;
	private final Duration seconds;
	private final List<Call> calls = new ArrayList<>();

	public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
	}

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			if (call.from().getHour() >= LATE_NIGHT_HOUR) {
				result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
			} else {
				result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
			}
		}

		return result;
	}
}
