package org.eternity.billing.step08;

import java.time.Duration;

import org.eternity.money.Money;

public class RegularPhone extends Phone {

	private final Money amount;
	private final Duration seconds;

	public RegularPhone(Money amount, Duration seconds, double taxRate) {
		super(taxRate);
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
