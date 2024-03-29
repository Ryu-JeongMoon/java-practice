package org.eternity.billing.step05;

import java.time.Duration;

import org.eternity.money.Money;

public class NightlyDiscountPhone extends Phone {

	private static final int LATE_NIGHT_HOUR = 22;

	private final Money nightlyAmount;

	public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
		super(regularAmount, seconds, taxRate);
		this.nightlyAmount = nightlyAmount;
	}

	@Override
	public Money calculateFee() {
		// 부모클래스의 calculateFee() 호출
		Money result = super.calculateFee();

		Money nightlyFee = Money.ZERO;
		for (Call call : getCalls()) {
			if (call.from().getHour() >= LATE_NIGHT_HOUR) {
				nightlyFee = nightlyFee.plus(
					getAmount().minus(nightlyAmount).times(
						call.getDuration().getSeconds() / getSeconds().getSeconds()));
			}
		}

		return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
	}
}
